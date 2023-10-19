package com.example.MarsRover.services;

import com.example.MarsRover.controllers.RoverController;
import com.example.MarsRover.dto.CommandDto;
import com.example.MarsRover.models.Direction;
import com.example.MarsRover.models.Rover;
import com.example.MarsRover.repository.RoverRepository;
import com.example.MarsRover.services.RoverService;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class RoverServiceImpTest {
    @Mock
    private RoverRepository roverRepository;
    @InjectMocks
    private RoverServiceImp service;

    @Test
    public  void  callService_WhenReceiveACommand(){

        Rover rover = new Rover();
        rover.setX(5);
        rover.setY(5);
        rover.setDirection(Direction.NORTH);


        List<Rover> roverList = new ArrayList<>();
        roverList.add(rover);
        when(roverRepository.findAll()).thenReturn(roverList);

        service.sendCommand("F");
        Rover frover = new Rover();
        frover.setX(5);
        frover.setY(4);
        frover.setDirection(Direction.NORTH);

        verify(roverRepository, times(1)).save(frover);
/*
        CommandDto commandDto = new CommandDto();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");

        commandDto.setCommands(commandsList);
        controller.sendCommand(commandDto);


        verify(roverService, times(1)).sendCommand("F");

 */
    }



}
