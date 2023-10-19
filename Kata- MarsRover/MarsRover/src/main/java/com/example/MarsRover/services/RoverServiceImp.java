package com.example.MarsRover.services;

import com.example.MarsRover.models.Direction;
import com.example.MarsRover.models.Obstacle;
import com.example.MarsRover.models.Rover;
import com.example.MarsRover.repository.ObstacleRepository;
import com.example.MarsRover.repository.RoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverServiceImp implements RoverService {
    @Autowired
     RoverRepository repository;

    @Autowired
    ObstacleRepository obstacleRepository;

    @Override
    public Rover get() {
        List<Rover> roverList = repository.findAll();
        return roverList.get(0);
    }

    @Override
    public void sendCommand(String command) {
        Rover rover = get();


        switch (command){
            case "F":  moveRover(rover, true); break;
            case "B":  moveRover(rover, false); break;
            case "R":  turnRover(rover, true); break;
            case "L":  turnRover(rover, false); break;
        }

            repository.save(rover);

    }

    private void turnRover(Rover rover, boolean isRigth) {
        Direction direction = rover.getDirection();
        Direction finalDirection = null;


        if (isRigth){
            switch (direction){
                case NORTH: finalDirection= Direction.EAST; break;
                case EAST: finalDirection= Direction.SOUTH; break;
                case SOUTH: finalDirection= Direction.WEST; break;
                case WEST: finalDirection= Direction.NORTH; break;
            }
        } else {
            switch (direction){
                case NORTH: finalDirection= Direction.WEST; break;
                case WEST: finalDirection= Direction.SOUTH; break;
                case SOUTH: finalDirection= Direction.EAST; break;
                case EAST: finalDirection= Direction.NORTH; break;
            }
        }
       rover.setDirection(finalDirection);
    }


    private  void moveRover( Rover rover, boolean isForward){
        Integer posXFinal = rover.getX();
        Integer posYFinal = rover.getY();

        Direction direction = rover.getDirection();
        if (Direction.WEST.equals(direction)
                || Direction.EAST.equals(direction)) {
            posXFinal -= isForward ? direction.getValue() : -direction.getValue();

        }
        if (Direction.NORTH.equals(direction)
                || Direction.SOUTH.equals(direction)) {
            posYFinal -= isForward ? direction.getValue() : -direction.getValue();

        }

        if (canMoveToThisPosition(posXFinal, posYFinal)) {
            rover.setX(posXFinal);
            rover.setY(posYFinal);
            
        }



    }

    private boolean canMoveToThisPosition(Integer posXFinal, Integer posYFinal) {
          List<Obstacle> obstacles=  obstacleRepository.findAll();

        for (Obstacle obstacle: obstacles) {
            if (obstacle.getX() == posXFinal && obstacle.getY() == posYFinal){
                    return false;
            }

        }
        return true;
    }
}
