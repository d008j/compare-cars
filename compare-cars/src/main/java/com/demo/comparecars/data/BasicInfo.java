package com.demo.comparecars.data;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "basic_info")
public class BasicInfo {

    private String brandName;
    private int onRoadPrice;
    private int userRating;
    private boolean isFinanceAvailable;
    private double serviceCost;

}
