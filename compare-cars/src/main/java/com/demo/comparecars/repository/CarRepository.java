package com.demo.comparecars.repository;

import com.demo.comparecars.data.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends MongoRepository<Car, String> {


}
