package com.fatec.anuncio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.anuncio.entities.Anuncio;

public interface AnuncioRepository extends JpaRepository <Anuncio, Integer>{
    
}