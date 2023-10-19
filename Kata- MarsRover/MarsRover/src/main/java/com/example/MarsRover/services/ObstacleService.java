package com.example.MarsRover.services;

import com.example.MarsRover.dto.ObstacleDto;
import com.example.MarsRover.models.Obstacle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ObstacleService {


    public List<Obstacle> getAll();
}
