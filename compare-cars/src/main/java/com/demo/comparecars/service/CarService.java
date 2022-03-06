package com.demo.comparecars.service;

import com.demo.comparecars.data.Car;
import com.demo.comparecars.data.CarComparisonRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    Car save(Car car);
    List<Car> getAll();
    Car update(Car car);
    void delete(String id);
    List<Car> findSimilarCars(String id);
    List<String> compareCars(CarComparisonRequest carComparisonRequest) throws IllegalAccessException;

}
