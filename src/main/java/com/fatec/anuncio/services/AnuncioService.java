package com.fatec.anuncio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.anuncio.entities.Anuncio;
import com.fatec.anuncio.repositories.AnuncioRepository;

@Service
public class AnuncioService {
    
    @Autowired
    private AnuncioRepository anuncioRepository;


    public List<Anuncio> getAnuncios(){
        return anuncioRepository.findAll();
    }

    public Anuncio save(Anuncio anuncio){
        return anuncioRepository.save(anuncio);
    }

}