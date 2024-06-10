package org.serratec.backend.livramento.repository;

import java.util.Optional;

import org.serratec.backend.livramento.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepository extends JpaRepository<Foto, Long>{
    Optional<Foto> findById(Long id);
}
