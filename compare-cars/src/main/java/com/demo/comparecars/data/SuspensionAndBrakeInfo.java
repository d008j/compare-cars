package com.demo.comparecars.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "suspension_brake_info")
@AllArgsConstructor
@NoArgsConstructor
public class SuspensionAndBrakeInfo {

    private String frontSuspension;
    private String rearSuspension;
    private String shockAbsorbersType;
    private String steeringType;
    private String steeringColumn;
    private String steeringGearType;
    private int turningRadius;
    private String frontBrakeType;
    private String rearBrakeType;
    private String emissionNormCompliance;
    private String tyreSize;
    private String tyreType;
    private String wheelSize;
}
