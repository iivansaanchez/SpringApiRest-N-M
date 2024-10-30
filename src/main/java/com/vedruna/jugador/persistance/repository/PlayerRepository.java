package com.vedruna.jugador.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.jugador.persistance.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
    
}
