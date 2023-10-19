package com.example.MarsRover.repository;

import com.example.MarsRover.models.Obstacle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObstacleRepository extends JpaRepository<Obstacle, Long> {
}
