package com.vedruna.jugador.dto;
import java.util.List;

import com.vedruna.jugador.persistance.models.Player;
import com.vedruna.jugador.persistance.models.Trophies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayersDTO {
    
    private String username;
    private List<TrophiesDTO> listTrophies;

    public PlayersDTO(Player player){

        this.username = player.getUsername();

        //Convertir lista de trofeos en lista de trofeosDTO
        for(Trophies t : player.getListTrophies()){
            TrophiesDTO trophiesDTO = new TrophiesDTO(t);
            this.listTrophies.add(trophiesDTO);
        }
    }

}
