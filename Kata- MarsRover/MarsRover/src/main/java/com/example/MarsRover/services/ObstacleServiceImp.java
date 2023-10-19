package com.example.MarsRover.services;

import com.example.MarsRover.dto.ObstacleDto;
import com.example.MarsRover.models.Obstacle;
import com.example.MarsRover.repository.ObstacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObstacleServiceImp implements ObstacleService {
    @Autowired
    private ObstacleRepository repository;
    @Override
    public List<Obstacle> getAll() {
        return repository.findAll();
    }
}
