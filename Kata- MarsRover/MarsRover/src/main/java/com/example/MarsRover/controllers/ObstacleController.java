package com.example.MarsRover.controllers;

import com.example.MarsRover.dto.ObstacleDto;
import com.example.MarsRover.dto.RoverDto;
import com.example.MarsRover.models.Obstacle;
import com.example.MarsRover.services.ObstacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObstacleController {
    @Autowired
    private ObstacleService service;

    @PostMapping("api/obstacle/")
    public void create(@RequestBody ObstacleDto obstacle){
        System.out.println(obstacle);
    }

    @GetMapping("api/obstacle/")
    public List<Obstacle> getAll(){
      return service.getAll();
    }
}
