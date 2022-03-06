package com.demo.comparecars.service.impl;

import com.demo.comparecars.data.*;
import com.demo.comparecars.repository.CarRepository;
import com.demo.comparecars.repository.ScoreConfigRepository;
import com.demo.comparecars.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ScoreConfigRepository scoreConfigRepository;

    @Override
    public Car save(Car car) {
        return carRepository.insert(car);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(String id) {
        try {
            Car car = carRepository.findById(id).get();
            carRepository.delete(car);
        } catch (Exception e) {
//            todo handle
        }

    }

    @Override
    public List<Car> findSimilarCars(String id) {
//        todo throw exception
        Car car = carRepository.findById(id).get();
        List<ScoreConfig> all = scoreConfigRepository.findAll();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (ScoreConfig each : all) {
            switch (each.getFieldName()) {
                case "seatingCapacity":
                    calculateScoreForSeatingCapacity(car, scoreMap, each.getScore());
                    break;
                case "price":
                    calculateScoreForPrice(car, scoreMap, each.getScore());
                    break;
                case "fuelType":
                    calculateScoreForFuelType(car, scoreMap, each.getScore());
                    break;
                case "bodyType":
                    calculateScoreForBodyType(car, scoreMap, each.getScore());
                    break;
                default:
//                    todo throw exception
            }
        }
        TreeSet<CarScore> sortedCars = new TreeSet<>();
        for (String carId : scoreMap.keySet()) {
            log.info("Car {} has score {}", carId, scoreMap.get(carId));
            Car currentCar = carRepository.findById(carId).get();
            CarScore carScore = CarScore.builder().car(currentCar).score(scoreMap.get(carId)).build();
            sortedCars.add(carScore);
        }

        List<Car> carList = sortedCars.stream()
                .map(CarScore::getCar)
                .collect(Collectors.toList());
        return carList;
    }

    private void calculateScoreForBodyType(Car car, HashMap<String, Integer> scoreMap, int score) {
        List<Car> similarBodyType = carRepository.findByExteriorInfo_BodyType(car.getExteriorInfo().getBodyType());
        for (Car eachCar : similarBodyType) {
            scoreMap.put(eachCar.getId(), scoreMap.getOrDefault(eachCar.getId(), 0) + score);
        }
    }

    private void calculateScoreForFuelType(Car car, HashMap<String, Integer> scoreMap, int score) {
        List<Car> similarBodyType = carRepository.findByFuelPerformanceInfo_FuelType(car.getFuelPerformanceInfo().getFuelType());
        for (Car eachCar : similarBodyType) {
            scoreMap.put(eachCar.getId(), scoreMap.getOrDefault(eachCar.getId(), 0) + score);
        }
    }

    private void calculateScoreForPrice(Car car, HashMap<String, Integer> scoreMap, int score) {
        List<Car> similarBodyType = carRepository.findByPrice(car.getPrice());
        for (Car eachCar : similarBodyType) {
            scoreMap.put(eachCar.getId(), scoreMap.getOrDefault(eachCar.getId(), 0) + score);
        }
    }

    private void calculateScoreForSeatingCapacity(Car car, HashMap<String, Integer> scoreMap, int score) {
        List<Car> similarBodyType = carRepository.findByDimension_SeatingCapacity(car.getDimension().getSeatingCapacity());
        for (Car eachCar : similarBodyType) {
            scoreMap.put(eachCar.getId(), scoreMap.getOrDefault(eachCar.getId(), 0) + score);
        }
    }

    @Override
    public List<String> compareCars(CarComparisonRequest request) throws IllegalAccessException {
        HashMap<String, List<CarAttribute>> carAttributes = new HashMap<>();
        Car baseCar = carRepository.findById(request.getBaseCarId()).get();
        log.info("Base car is {}", baseCar);
        List<Car> cars = new ArrayList<>();
        for (String eachId : request.getOtherIds()){
            Car currentCar = carRepository.findById(eachId).get();
            log.info("current car is {}", currentCar);
            cars.add(currentCar);
        }

        List<String> changedProperties = new ArrayList<>();
        for (Car eachCar : cars) {
            difference(baseCar,eachCar,carAttributes,changedProperties,null);

        }
        return changedProperties;
    }

    private final Set<Class> BASE_TYPES = new HashSet(Arrays.asList(
            String.class, Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Void.class));

    public boolean isBaseType(Class clazz) {
        return BASE_TYPES.contains(clazz);
    }

    private void difference(Object s1, Object s2, HashMap<String, List<CarAttribute>> carAttributes, List<String> changedProperties, String parent) throws IllegalAccessException {
        for (Field field : s1.getClass().getDeclaredFields()) {
            if (parent == null) {
                parent = s1.getClass().getSimpleName();
            }
            field.setAccessible(true);
            Object value1 = field.get(s1);
            Object value2 = field.get(s2);
            if (value1 == null && value2 == null) {
                continue;
            }
            if (value1 == null || value2 == null) {
                changedProperties.add(parent + "." + field.getName());
            } else {
                if (isBaseType(value1.getClass())) {
                    if (!Objects.equals(value1, value2)) {
                        changedProperties.add(parent + "." + field.getName());
                    }
                } else {
                    difference(value1, value2, carAttributes,changedProperties, parent + "." + field.getName());
                }

            }
        }

    }
}
