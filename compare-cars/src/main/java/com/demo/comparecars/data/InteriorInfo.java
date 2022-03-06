package com.demo.comparecars.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "interior_info")
@AllArgsConstructor
@NoArgsConstructor
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
