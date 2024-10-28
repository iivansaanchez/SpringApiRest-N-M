package com.vedruna.jugador.services.players;

import java.util.List;

import com.vedruna.jugador.dto.PlayersDTO;
import com.vedruna.jugador.persistance.models.Player;

public interface PlayerServiceI {
    

    /*
     * Crear una api rest que tenga los siguientes endpoints:

3. Consultar todos los trofeos (No deben verse los jugadores)

5. Crear nuevo trofeo (Debe inicializarse su colección de jugadores a vacía )

     */


    //Funcion para obtener todos los jugadores
    List<PlayersDTO> showAllPlayers();

    //Funcion para consultar un solo jugador
    PlayersDTO showPlayersById(Integer id);

    //Funcion para crear un jugador
    void addPlayer(Player player);

    //Funcion para añadir trofeo
    void addTrophies(Integer idPlayer, Integer idtTrophies);

    //Funcion para borrar los trofeos de un jugador
    void deletePlayer(Integer id);}
