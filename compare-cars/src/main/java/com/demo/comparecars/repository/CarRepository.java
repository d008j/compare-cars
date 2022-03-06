package com.demo.comparecars.repository;

import com.demo.comparecars.data.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends MongoRepository<Car, String> {

//    @Query("{similarCars : null}")
//    List<Car> findBySimilarCarsNull();
    List<Car> findByExteriorInfo_BodyType(String bodyType);
    List<Car> findByPrice(double price);
    List<Car> findByDimension_SeatingCapacity(int seatingCapacity);
    List<Car> findByFuelPerformanceInfo_FuelType(String fuelType);

}
