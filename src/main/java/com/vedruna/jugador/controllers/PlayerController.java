package com.vedruna.jugador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vedruna.jugador.dto.PlayersDTO;
import com.vedruna.jugador.persistance.models.Player;
import com.vedruna.jugador.services.players.PlayerServiceI;

import java.util.List;

@RestController
@RequestMapping("api/v1/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerServiceI playerService;

    // Función para obtener todos los jugadores
    @GetMapping
    public List<PlayersDTO> getAllPlayers() {
        return playerService.showAllPlayers();
    }

    // Función para consultar un solo jugador
    @GetMapping("/{id}")
    public PlayersDTO getPlayerById(@PathVariable Integer id) {
        return playerService.showPlayersById(id);
    }

    // Función para crear un jugador
    @PostMapping("/addPlayer")
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    // Función para añadir un trofeo a un jugador
    @PutMapping("/addTrophy/{idPlayer}/{idTrophy}")
    public void addTrophy(@PathVariable Integer idPlayer, @PathVariable Integer idTrophy) {
        playerService.addTrophies(idPlayer, idTrophy);
    }

    // Función para borrar un jugador y sus trofeos
    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }
}

