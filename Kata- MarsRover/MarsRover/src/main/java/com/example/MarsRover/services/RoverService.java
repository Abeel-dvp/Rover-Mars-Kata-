package com.example.MarsRover.services;

import com.example.MarsRover.models.Rover;
import org.springframework.stereotype.Service;


public interface RoverService {
    public Rover get();

    void sendCommand(String command);
}
