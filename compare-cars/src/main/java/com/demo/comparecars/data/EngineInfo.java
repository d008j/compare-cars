package com.demo.comparecars.data;


import com.demo.comparecars.data.enums.DriveType;
import com.demo.comparecars.data.enums.TransmissionType;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "engine_info")
public class EngineInfo {

    private String engineType;
    private double displacement;
    private int cylinderCount;
    private boolean isFastCharging;
    private String maxPower;
    private String maxTorque;
    private int valvesPerCylinder;
    private String valveConfiguration;
    private String fuelSupplySystem;
    private boolean isTurboCharger;
    private boolean isSuperCharger;
    private TransmissionType transmissionType;
    private String gearBox;
    private boolean isMildHybrid;
    private DriveType driveType;
    private boolean isClutchType;
}