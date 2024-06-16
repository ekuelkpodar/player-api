package com.example.playerapi.controller;

import com.example.playerapi.entity.Player;
import com.example.playerapi.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@Slf4j
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        log.info("GET /api/players called");
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        log.info("GET /api/players/{} called", id);
        return playerService.getPlayerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.warn("Player with id {} not found", id);
                    return ResponseEntity.notFound().build();
                });
    }
}
