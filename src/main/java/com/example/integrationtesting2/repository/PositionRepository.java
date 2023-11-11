package com.example.integrationtesting2.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.integrationtesting2.pojo.Position;

public interface PositionRepository extends CrudRepository<Position, Integer> {
}
