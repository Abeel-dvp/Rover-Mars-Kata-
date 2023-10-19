package com.example.MarsRover.repository;

import com.example.MarsRover.models.Rover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoverRepository extends JpaRepository<Rover,Long> {
}
