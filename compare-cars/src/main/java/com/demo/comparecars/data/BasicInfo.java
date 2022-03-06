package com.demo.comparecars.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "basic_info")
@AllArgsConstructor
@NoArgsConstructor
public class BasicInfo {

    private String brandName;
    private int onRoadPrice;
    private int userRating;
    private boolean isFinanceAvailable;
    private double serviceCost;

}
