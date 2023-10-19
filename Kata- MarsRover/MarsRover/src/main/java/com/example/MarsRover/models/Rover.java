package com.example.MarsRover.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "rover")
public class Rover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "posx")
    private Integer x;
    @Column(name = "posy")
    private Integer y;
    @Enumerated(EnumType.STRING)
    @Column(name = "direction")
   private Direction direction;
}
