package com.demo.comparecars.service;

import com.demo.comparecars.data.*;
import com.demo.comparecars.exception.GenericException;
import com.demo.comparecars.repository.CarRepository;
import com.demo.comparecars.repository.ScoreConfigRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @MockBean
    CarRepository carRepository;

    @MockBean
    ScoreConfigRepository scoreConfigRepository;

    Car car1;

    Car car2;

    Car car3;

    @Autowired
    CarService carService;

    @Before
    public void setUp() {
        car1 = new Car();
        car1.setId("1");
        car1.setPrice(100);
        car1.setBrand("Maruti");
        Dimension dimension = new Dimension();
        dimension.setSeatingCapacity(6);
        dimension.setDoorCount(4);
        dimension.setHeight(5);
        dimension.setLength(6);


        ExteriorInfo exteriorInfo = new ExteriorInfo();
        exteriorInfo.setBodyType("bodyType1");

        FuelPerformanceInfo fuelPerformanceInfo = new FuelPerformanceInfo();
        fuelPerformanceInfo.setFuelType("petrol");

        car1.setDimension(dimension);
        car1.setExteriorInfo(exteriorInfo);
        car1.setFuelPerformanceInfo(fuelPerformanceInfo);


        car2 = new Car();
        car2.setId("2");
        car2.setPrice(1000);
        car2.setBrand("BMW");
        dimension = new Dimension();
        dimension.setSeatingCapacity(5);
        dimension.setDoorCount(5);
        dimension.setHeight(8);
        dimension.setLength(9);


        exteriorInfo = new ExteriorInfo();
        exteriorInfo.setBodyType("bodyType2");

        fuelPerformanceInfo = new FuelPerformanceInfo();
        fuelPerformanceInfo.setFuelType("diesel");

        car2.setDimension(dimension);
        car2.setExteriorInfo(exteriorInfo);
        car2.setFuelPerformanceInfo(fuelPerformanceInfo);

        car3 = new Car();
        car3.setId("3");
        car3.setPrice(10000);
        car3.setBrand("Hyundai");
        dimension = new Dimension();
        dimension.setSeatingCapacity(7);
        dimension.setDoorCount(6);
        dimension.setHeight(9);
        dimension.setLength(10);


        exteriorInfo = new ExteriorInfo();
        exteriorInfo.setBodyType("bodyType3");

        fuelPerformanceInfo = new FuelPerformanceInfo();
        fuelPerformanceInfo.setFuelType("petrol");

        car3.setDimension(dimension);
        car3.setExteriorInfo(exteriorInfo);
        car3.setFuelPerformanceInfo(fuelPerformanceInfo);


        when(carRepository.insert(car1)).thenReturn(car1);
        when(carRepository.insert(car2)).thenReturn(car2);
        when(carRepository.insert(car3)).thenReturn(car3);
        when(carRepository.findById(car1.getId())).thenReturn(Optional.of(car1));
        when(carRepository.findById(car2.getId())).thenReturn(Optional.of(car2));
        when(carRepository.findById(car3.getId())).thenReturn(Optional.of(car3));

        List<ScoreConfig> allConfig = new ArrayList<>();

        ScoreConfig scoreConfig1 = new ScoreConfig();
        scoreConfig1.setScore(10);
        scoreConfig1.setFieldName("price");

        ScoreConfig scoreConfig2 = new ScoreConfig();
        scoreConfig2.setScore(9);
        scoreConfig2.setFieldName("seatingCapacity");

        ScoreConfig scoreConfig3 = new ScoreConfig();
        scoreConfig3.setScore(8);
        scoreConfig3.setFieldName("fuelType");

        ScoreConfig scoreConfig4 = new ScoreConfig();
        scoreConfig4.setScore(7);
        scoreConfig4.setFieldName("bodyType");

        allConfig.add(scoreConfig1);
        allConfig.add(scoreConfig2);
        allConfig.add(scoreConfig3);
        allConfig.add(scoreConfig4);

        when(scoreConfigRepository.findAll()).thenReturn(allConfig);
        when(carRepository.findByDimension_SeatingCapacity(car1.getDimension().getSeatingCapacity())).thenReturn(Collections.singletonList(car2));

        when(carRepository.findByPrice(car1.getPrice())).thenReturn(Collections.singletonList(car3));
        when(carRepository.findByFuelPerformanceInfo_FuelType(car1.getFuelPerformanceInfo().getFuelType())).thenReturn(Collections.singletonList(car3));
        when(carRepository.findByExteriorInfo_BodyType(car1.getExteriorInfo().getBodyType())).thenReturn(Collections.singletonList(car3));

    }

    @Test
    public void testSave() {
        Car createdCar = carService.save(car1);
        System.out.println(createdCar.toString());
        Assert.assertNotNull(createdCar);
    }

    @Test
    public void testFindSimilarCars() {


        List<Car> similarCars = carService.findSimilarCars(car1.getId());
        System.out.println("Returned cars length " + similarCars.size());
        Assert.assertNotNull(similarCars);
    }

    @Test
    public void testCompareCars() throws IllegalAccessException {

        List<String> idsList = new ArrayList<>();
        idsList.add((car2.getId()));
        idsList.add(car3.getId());
        CarComparisonRequest carComparisonRequest = CarComparisonRequest.builder().otherIds(idsList).baseCarId(car1.getId()).build();

        HashMap<String, List<CarAttribute>> response = carService.compareCars(carComparisonRequest);
        System.out.println("Response is " + response);
        Assert.assertNotNull(response);

        idsList.remove(1);
        Car carForException = new Car();
        carForException.setId("5");
        idsList.add("5");

        CarComparisonRequest exceptionRequest = CarComparisonRequest.builder().otherIds(idsList).baseCarId(car1.getId()).build();
        Assert.assertThrows(Exception.class, () ->carService.compareCars(exceptionRequest));
    }


}
