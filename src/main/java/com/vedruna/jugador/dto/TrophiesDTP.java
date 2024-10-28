package com.vedruna.jugador.dto;

import java.util.List;
import com.vedruna.jugador.persistance.models.Trophies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrophiesDTP {

    private List<Trophies> listTrophies;
    
}
