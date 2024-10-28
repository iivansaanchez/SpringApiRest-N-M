package com.vedruna.jugador.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.jugador.persistance.models.PlayerHasTrophies;
import com.vedruna.jugador.persistance.models.PlayerTrophyId;

public interface PlayerHasTrophiesRepository extends JpaRepository<PlayerHasTrophies, PlayerTrophyId>{

    List<PlayerHasTrophies> findByIdPlayer(Integer playerId);
    
}
