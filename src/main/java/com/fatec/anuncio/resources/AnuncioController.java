package com.fatec.anuncio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.anuncio.entities.Anuncio;
import com.fatec.anuncio.services.AnuncioService;

@RestController
@RequestMapping("anuncios")
@CrossOrigin
public class AnuncioController {
    
    @Autowired
    private AnunciosService anuncioService;


    @GetMapping
    public ResponseEntity<List<Anuncio>> getAnuncios(){
        List<Anuncio> anuncioses = anuncioService.getAnuncios();
        return ResponseEntity.ok().body(anuncioses);
    }

    @PostMapping
    public ResponseEntity<Anuncio> saveAnuncio(@RequestBody Anuncio anuncio){
        Anuncio anuncioSalvo = anuncioService.save(anuncio);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(anuncio.getId())
                .toUri();

        return ResponseEntity.created(location).body(anuncioSalvo);
    }
}