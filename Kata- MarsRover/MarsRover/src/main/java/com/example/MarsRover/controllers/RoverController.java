package com.example.MarsRover.controllers;


import com.example.MarsRover.dto.CommandDto;
import com.example.MarsRover.dto.RoverDto;
import com.example.MarsRover.models.Direction;
import com.example.MarsRover.models.Rover;
import com.example.MarsRover.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoverController {
    @Autowired
    private RoverService service;
    @GetMapping("api/rover/")
    public Rover get(){
        return service.get();
    }
    @PostMapping("api/rover/")
    public void create(@RequestBody RoverDto rover){
        System.out.println(rover);
    }

    @PostMapping("api/rover/command/")
    public void sendCommand(@RequestBody CommandDto command){

        System.out.println(command);

        for (String commandes:command.getCommands()) {
            System.out.println(commandes);
            service.sendCommand(commandes);
        }
    }
}
