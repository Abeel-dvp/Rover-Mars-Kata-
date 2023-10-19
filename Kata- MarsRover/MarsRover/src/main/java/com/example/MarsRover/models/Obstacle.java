package com.example.MarsRover.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "obstacle")
public class Obstacle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "posx")
    private Integer x;
    @Column(name = "posy")
    private Integer y;

}
