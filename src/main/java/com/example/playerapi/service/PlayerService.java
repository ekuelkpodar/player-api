package com.example.playerapi.service;

import com.example.playerapi.entity.Player;
import com.example.playerapi.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        log.info("Fetching all players");
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(int id) {
        log.info("Fetching player with id: {}", id);
        return playerRepository.findById(id);
    }
}
