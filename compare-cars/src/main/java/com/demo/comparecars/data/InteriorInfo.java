package com.demo.comparecars.data;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "interior_info")
public class InteriorInfo {

    private boolean tachometer;
    private boolean electronicMultiTripmeter;
    private boolean leatherSeats;
    private boolean fabricUpholstery;
    private boolean leatherWheel;
    private boolean gloveCompartment;
    private boolean digitalClock;
    private boolean outsideTemperatureDisplay;
    private boolean digitalOdometer;

}
