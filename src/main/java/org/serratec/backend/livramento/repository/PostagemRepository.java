package org.serratec.backend.livramento.repository;

import org.serratec.backend.livramento.model.Postagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}
