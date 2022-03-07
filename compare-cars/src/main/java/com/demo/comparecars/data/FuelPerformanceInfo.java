package com.demo.comparecars.data;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "fuel_performance_info")
public class FuelPerformanceInfo {

    @Indexed
    private String fuelType;
    private double mileage;
    private double fuelTankCapacity;
    private String emissionNormCompliance;

}
