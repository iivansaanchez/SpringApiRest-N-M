package com.vedruna.jugador.services.players;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.jugador.dto.PlayersDTO;
import com.vedruna.jugador.dto.TrophiesDTO;
import com.vedruna.jugador.persistance.models.Player;
import com.vedruna.jugador.persistance.models.Trophies;
import com.vedruna.jugador.persistance.repository.PlayerRepository;
import com.vedruna.jugador.persistance.repository.TrophiesRepository;

@Service
public class PlayerServiceImp implements PlayerServiceI{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TrophiesRepository trophiesRepository;

    @Override
    public List<PlayersDTO> showAllPlayers() {
        //Creamos una lista de playersDTO
        List<PlayersDTO> listPlayersDTO = new ArrayList<>();
        //Rescatamos todos los jugadores
        List<Player> listPlayers = playerRepository.findAll();

        //Una vez rescatado lo recorremos
        for(Player player : listPlayers){
            List<TrophiesDTO> listTrophiesDTO = new ArrayList<>();
            for(Trophies trophies : player.getListTrophies()){
                listTrophiesDTO.add(new TrophiesDTO(trophies.getTitle(), trophies.getDescription()));
            }
            
            //Creamos un playerDTO y almacenamos los datos que necesitamos para crear el DTO
            PlayersDTO playersDTO = new PlayersDTO(player.getUsername(), listTrophiesDTO);
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
        List<TrophiesDTO> lTrophiesDTOs = new ArrayList<>();
        if(player != null){
            //Creamos un playerDTO y lo rellenamos con los datos del player rescatado
            playersDTO.setUsername(player.getUsername());
            List<Trophies> listTrophies = player.getListTrophies();
            for(Trophies t : listTrophies){
                TrophiesDTO trophiesDTO = new TrophiesDTO(t);
                lTrophiesDTOs.add(trophiesDTO);
            }
            playersDTO.setListTrophies(lTrophiesDTOs);
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
        playerRepository.delete(player);
    }

    @Override
    public void addTrophies(Integer playerId, Integer trophyId) {

        //Rescatamos el Jugador
        Player player = playerRepository.findById(playerId).orElse(null);
        //Rescatamos el Trofeo
        Trophies trophies = trophiesRepository.findById(trophyId).orElse(null);
        //Lo añadimos a la lista
        if(player != null && trophies != null){
            //Creamos una lista de trofeos para modificarla luego
            List<Trophies> listTrophiesUp = player.getListTrophies();
            //Añadimos el nuevo trofeo al jugador
            listTrophiesUp.add(trophies);
            //Actualizamos la lista de trofeos del jugador
            player.setListTrophies(listTrophiesUp);
            //Lo añadimos a la base de datos
            playerRepository.save(player);
        } 
    }  
}
