package com.demo.comparecars.data;


import com.demo.comparecars.data.enums.Brand;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "car")
public class Car {

    @Id
    private long id;
    private BasicInfo basicInfo;
    private Dimension dimension;
    private EngineInfo engineInfo;
    private ExteriorInfo exteriorInfo;
    private FuelPerformanceInfo fuelPerformanceInfo;
    private InteriorInfo interiorInfo;
    private SafetyInfo safetyInfo;
    private SuspensionAndBrakeInfo suspensionAndBrakeInfo;

    private Brand brand;
    private String model;
    private String variant;
//    todo image
    private String image;
    private double price;


}
