package org.serratec.backend.livramento.controller;

import java.util.List;

import org.serratec.backend.livramento.model.Postagem;
import org.serratec.backend.livramento.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publicacao")
public class PublicacaoController {

    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    public ResponseEntity<List<Postagem>> listarPostagens() {
        List<Postagem> postagens = postagemRepository.findAll();
        return ResponseEntity.ok(postagens);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Postagem criarPostagem(@RequestBody Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postagem> atualizarPostagem(@PathVariable Long id, @RequestBody Postagem postagemAtualizada) {
        if (!postagemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        // Busca a postagem existente no banco de dados
        Postagem postagemExistente = postagemRepository.findById(id).get();

        // Atualiza apenas os campos que foram modificados na postagem existente
        postagemExistente.setTitulo(postagemAtualizada.getTitulo());
        postagemExistente.setDescricao(postagemAtualizada.getDescricao());
        postagemExistente.setNota(postagemAtualizada.getNota());
        postagemExistente.setUsuario(postagemAtualizada.getUsuario());

        // Salva a postagem existente de volta no banco de dados
        postagemExistente = postagemRepository.save(postagemExistente);
        
        return ResponseEntity.ok(postagemExistente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPostagem(@PathVariable Long id) {
        if (!postagemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        postagemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

