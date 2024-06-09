package org.serratec.backend.livramento.service;

import java.util.List;

import org.serratec.backend.livramento.model.Postagem;
import org.serratec.backend.livramento.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	public List<Postagem> listarTodos() {
		return postagemRepository.findAll();
	}

	public Postagem salvar(Postagem postagem) {
		return postagemRepository.save(postagem);
	}

}
