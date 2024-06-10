package org.serratec.backend.livramento.controller;

import java.io.IOException;

import org.serratec.backend.livramento.model.Foto;
import org.serratec.backend.livramento.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @PostMapping("/uploadFoto")
    public Foto uploadFoto(@RequestParam("file") MultipartFile file, @RequestParam("postagemId") Long postagemId) {
        try {
            return fotoService.salvarFoto(file, postagemId);
        } catch (IOException e) {
            throw new RuntimeException("Falha ao salvar foto", e);
        }
    }
}
