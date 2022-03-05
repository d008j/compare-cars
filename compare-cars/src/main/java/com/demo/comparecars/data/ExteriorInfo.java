package com.demo.comparecars.data;


import com.demo.comparecars.data.enums.BodyType;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "interior_info")
public class ExteriorInfo {

    private BodyType bodyType;
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
