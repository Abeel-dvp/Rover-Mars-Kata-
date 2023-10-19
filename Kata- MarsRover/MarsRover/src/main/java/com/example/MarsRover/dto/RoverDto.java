package com.example.MarsRover.dto;

import com.example.MarsRover.models.Direction;
import lombok.Data;

@Data
public class RoverDto {
    private Integer x;
    private Integer y;

    private Direction direction;
}
