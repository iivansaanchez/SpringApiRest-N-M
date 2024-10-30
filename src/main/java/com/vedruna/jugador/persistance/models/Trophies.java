package com.vedruna.jugador.persistance.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="trophies")
public class Trophies {
    
    @Id
    @Column(name="idtrophie")
    private Integer idTrophie;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToMany(
        mappedBy = "listTrophies"
    )
    private List<Player> listPlayers = new ArrayList<>();

}
