package com.demo.comparecars.data;

import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
public class CarComparisonRequest {

    String baseCarId;
    List<String> otherIds;

}
