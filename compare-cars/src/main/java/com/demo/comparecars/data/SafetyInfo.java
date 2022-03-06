package com.demo.comparecars.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "safety_info")
@AllArgsConstructor
@NoArgsConstructor
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
