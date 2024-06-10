package org.serratec.backend.livramento.service;

import java.util.Optional;

import org.serratec.backend.livramento.model.Foto;
import org.serratec.backend.livramento.model.Postagem;
import org.serratec.backend.livramento.repository.FotoRepository;
import org.serratec.backend.livramento.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    @Autowired
    private PostagemRepository postagemRepository;

    public Foto salvarFoto(MultipartFile file, Long postagemId) throws IOException {
        Optional<Postagem> postagemOpt = postagemRepository.findById(postagemId);
        if (postagemOpt.isPresent()) {
            Postagem postagem = postagemOpt.get();
            Foto foto = new Foto();
            foto.setDados(file.getBytes());
            foto.setTipo(file.getContentType());
            foto.setNome(file.getOriginalFilename());
            fotoRepository.save(foto);

            postagem.setFoto(foto);
            postagemRepository.save(postagem);
            return foto;
        } else {
            throw new RuntimeException("Postagem não encontrada");
        }
    }
}
