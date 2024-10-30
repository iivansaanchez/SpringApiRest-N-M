package com.vedruna.jugador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.jugador.dto.TrophiesDTO;
import com.vedruna.jugador.persistance.models.Trophies;
import com.vedruna.jugador.services.trophies.TrophieServiceI;

@RestController
@RequestMapping("api/v1/trophie")
@CrossOrigin
public class TrophiesController {

    @Autowired
    TrophieServiceI trophieServiceI;

    @GetMapping
    public List<TrophiesDTO> showAllTrophies(){
        return trophieServiceI.showAllTrophies();
    }

    @PostMapping("/addTrophie")
    public void addTrophie(@RequestBody Trophies trophies){
        trophieServiceI.addTrophies(trophies);
    }
    
}
