package com.vedruna.jugador.services.players;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.jugador.dto.PlayersDTO;
import com.vedruna.jugador.persistance.models.Player;
import com.vedruna.jugador.persistance.models.PlayerHasTrophies;
import com.vedruna.jugador.persistance.models.Trophies;
import com.vedruna.jugador.persistance.repository.PlayerHasTrophiesRepository;
import com.vedruna.jugador.persistance.repository.PlayerRepository;
import com.vedruna.jugador.persistance.repository.TrophiesRepository;

@Service
public class PlayerServiceImp implements PlayerServiceI{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TrophiesRepository trophiesRepository;

    @Autowired
    PlayerHasTrophiesRepository playerHasTrophiesRepository;
    @Override
    public List<PlayersDTO> showAllPlayers() {
        //Creamos una lista de playersDTO
        List<PlayersDTO> listPlayersDTO = new ArrayList<>();
        //Rescatamos todos los jugadores
        List<Player> listPlayers = playerRepository.findAll();
        //Una vez rescatado lo recorremos
        for(Player player : listPlayers){
            //Creamos un playerDTO y almacenamos los datos que necesitamos para crear el DTO
            PlayersDTO playersDTO = new PlayersDTO(player.getUsername(), player.getListTrophies());
            //Lo añadimos al nuevo array
            listPlayersDTO.add(playersDTO);
        }
        return listPlayersDTO; 
    }

    @Override
    public PlayersDTO showPlayersById(Integer id) {
        //Creamos el playerDTO
        PlayersDTO playersDTO = new PlayersDTO();
        //Rescatamos le player
        Player player = playerRepository.findById(id).orElse(null);
        //Si existe lo devolvemos con el DTO
        if(player != null){
            //Creamos un playerDTO y lo rellenamos con los datos del player rescatado
            playersDTO.setUsername(player.getUsername());
            playersDTO.setListTrophies(player.getListTrophies());
        }

        return playersDTO;
    }

    @Override
    public void addPlayer(Player player) {
        //Inicialiamos la lista de trofeos
        player.setListTrophies(new ArrayList<>());
        //Lo guardamos en la base de datos
        playerRepository.save(player);
    }

   @Override
    public void deletePlayer(Integer id) {
        // Rescatamos el player por su id
        Player player = playerRepository.findById(id).orElse(null);

        if (player != null) {
            //Extraemos la lista de trofeos que hay con ese id de jugador
            List<PlayerHasTrophies> playerTrophies = playerHasTrophiesRepository.findByIdPlayer(id);
            for (PlayerHasTrophies playerTrophy : playerTrophies) {
                //Borramos todas
                playerHasTrophiesRepository.delete(playerTrophy);
            }
            
            //Eliminamos el jugador
            playerRepository.delete(player);
        }
    }

    @Override
    public void addTrophies(Integer playerId, Integer trophyId) {
        // Busca el jugador por ID
        Player player = playerRepository.findById(playerId).orElseThrow(() -> 
        new RuntimeException("Player not found with id: " + playerId));
    
        // Busca el trofeo por ID
        Trophies trophy = trophiesRepository.findById(trophyId).orElseThrow(() -> 
        new RuntimeException("Trophy not found with id: " + trophyId));

        // Crea una nueva asociación en la tabla intermedia
        PlayerHasTrophies playerHasTrophy = new PlayerHasTrophies();
        playerHasTrophy.setPlayer(player);
        playerHasTrophy.setTrophy(trophy);

        // Guarda la asociación
        playerHasTrophiesRepository.save(playerHasTrophy);
    }  
}
