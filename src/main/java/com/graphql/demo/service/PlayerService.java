package com.graphql.demo.service;

import com.graphql.demo.model.Player;
import com.graphql.demo.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>();
    private AtomicInteger id = new AtomicInteger();

    public void addPlayer(String name, Team team){
        Player player = new Player(id.getAndIncrement(),name,team);
        players.add(player);
    }

    public Optional<Player> getPlayer(int id){
        return players.stream().filter(player -> player.id() ==id).findFirst();
    }

    public List<Player> getAllPlayers(){
        return players;
    }

    @PostConstruct
    public void init(){

        players.add(new Player(1, "MSD", Team.CSK));

    }

}
