package com.vedruna.jugador.persistance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="players_has_trophies")
@IdClass(PlayerTrophyId.class)
public class PlayerHasTrophies {

    @Id
    @Column(name = "players_idplayer")
    private Integer idPlayer;

    @Id
    @Column(name = "trophies_idtrophie")
    private Integer idTrophie; 

    @ManyToOne
    @JoinColumn(name = "players_idplayer", referencedColumnName = "idPlayer")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "trophies_idtrophie", referencedColumnName = "idTrophie")
    private Trophies trophy;
    

}
