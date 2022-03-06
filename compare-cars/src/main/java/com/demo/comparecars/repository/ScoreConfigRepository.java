package com.demo.comparecars.repository;

import com.demo.comparecars.data.ScoreConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreConfigRepository extends MongoRepository<ScoreConfig, String> {
}
