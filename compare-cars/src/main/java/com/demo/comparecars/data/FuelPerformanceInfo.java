package com.demo.comparecars.data;


import com.demo.comparecars.data.enums.FuelType;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "fuel_performance_info")
public class FuelPerformanceInfo {

    private FuelType fuelType;
    private double mileage;
    private double fuelTankCapacity;
    private String emissionNormCompliance;

}
