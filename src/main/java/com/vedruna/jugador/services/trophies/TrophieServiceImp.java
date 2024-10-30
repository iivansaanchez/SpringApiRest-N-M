package com.vedruna.jugador.services.trophies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.jugador.dto.TrophiesDTO;
import com.vedruna.jugador.persistance.models.Trophies;
import com.vedruna.jugador.persistance.repository.TrophiesRepository;

@Service
public class TrophieServiceImp  implements TrophieServiceI{

    @Autowired
    TrophiesRepository trophiesRepository;
    @Override
    public List<TrophiesDTO> showAllTrophies() {
        List<Trophies> listTrophies = trophiesRepository.findAll();
        List<TrophiesDTO> listTrophiesDTO = new ArrayList<>();

        for(Trophies t : listTrophies){
            TrophiesDTO trophiesDTO = new TrophiesDTO(t);
            listTrophiesDTO.add(trophiesDTO);
        }
        return listTrophiesDTO;
    }

    @Override
    public void addTrophies(Trophies trophies) {
        trophiesRepository.save(trophies);
    }
    
}
