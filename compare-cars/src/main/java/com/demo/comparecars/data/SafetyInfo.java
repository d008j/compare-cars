package com.demo.comparecars.data;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "safety_info")
public class SafetyInfo {

    private boolean antiLockBrakingSystem;
    private boolean brakeAssist;
    private boolean centralLocking;
    private boolean powerDoorLocks;
    private boolean childSafetyLocks;
    private boolean antiTheftAlarm;
    private int airbagCount;
    private boolean driverAirbag;
    private boolean passengerAirbag;

}
