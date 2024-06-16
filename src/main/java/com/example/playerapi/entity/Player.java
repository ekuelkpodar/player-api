package com.example.playerapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String team;
    private String position;
}
