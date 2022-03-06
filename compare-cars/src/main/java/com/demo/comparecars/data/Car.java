package com.demo.comparecars.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "car")
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    private String id;
    private BasicInfo basicInfo;
    private Dimension dimension;
    private EngineInfo engineInfo;
    private ExteriorInfo exteriorInfo;
    private FuelPerformanceInfo fuelPerformanceInfo;
    private InteriorInfo interiorInfo;
    private SafetyInfo safetyInfo;
    private SuspensionAndBrakeInfo suspensionAndBrakeInfo;
    private String brand;
    private String model;
    private String variant;
//    todo image
    private String image;
    @Indexed
    private double price;

}
