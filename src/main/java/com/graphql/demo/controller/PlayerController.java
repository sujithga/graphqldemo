package com.graphql.demo.controller;

import com.graphql.demo.model.Player;
import com.graphql.demo.service.PlayerService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    public List<Player> findAll(){
        List<Player> players = playerService.getAllPlayers();
        players.stream().forEach(a -> {
            System.out.println(a.id());
            System.out.println(a.team());
            System.out.println(a.name());
        });
        return players;
    }
}



