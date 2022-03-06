package com.demo.comparecars.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "dimension")
@AllArgsConstructor
@NoArgsConstructor
public class Dimension {

    private double length;
    private double width;
    private double height;
    private double groundClearanceUnladen;
    private double wheelBase;
    private double frontTread;
    private double rearTread;
    private double frontLegroom;
    @Indexed
    private int seatingCapacity;
    private double bootSpace;
    private int doorCount;
}
