package com.demo.comparecars.data;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "exterior_info")
public class ExteriorInfo {

    @Indexed
    private String bodyType;
    private boolean adjustableHeadlights;
    private boolean fogLightsFront;
    private boolean fogLightsRear;
    private boolean headlampWashers;
    private boolean rainSensingWiper;
    private boolean rearWindowWiper;
    private boolean rearWindowWasher;
    private boolean rearWindowDefogger;
    private boolean alloyWheels;
    private boolean powerAntenna;
    private boolean tintedGlass;
    private boolean rearSpoiler;
    private boolean convertibleTop;
}
