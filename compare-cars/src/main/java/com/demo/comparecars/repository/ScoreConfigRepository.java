package com.demo.comparecars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreConfigRepository extends MongoRepository<ScoreConfigRepository, String> {
}
