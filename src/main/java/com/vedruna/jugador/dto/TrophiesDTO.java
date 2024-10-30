package com.vedruna.jugador.dto;


import com.vedruna.jugador.persistance.models.Trophies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrophiesDTO {

    private String title;
    private String description;

    public TrophiesDTO(Trophies trophies){
        this.title = trophies.getTitle();
        this.description = trophies.getDescription();
    }

    
}
