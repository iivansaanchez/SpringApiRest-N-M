package com.vedruna.jugador.services.trophies;

import java.util.List;

import com.vedruna.jugador.dto.TrophiesDTO;
import com.vedruna.jugador.persistance.models.Trophies;

public interface TrophieServiceI {

    List<TrophiesDTO> showAllTrophies();

    void addTrophies(Trophies trophies);
    
}
