package com.vedruna.jugador.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.jugador.persistance.models.Trophies;

public interface TrophiesRepository extends JpaRepository<Trophies, Integer>{
    
}
