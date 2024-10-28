package com.vedruna.jugador.dto;
import java.util.List;

import com.vedruna.jugador.persistance.models.PlayerHasTrophies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayersDTO {
    
    private String username;
    private List<PlayerHasTrophies> listTrophies;

}
