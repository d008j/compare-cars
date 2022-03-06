package com.demo.comparecars.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@Builder
@AllArgsConstructor
public class CarComparisonResponse {

    String groupHeading;
    List<CarAttribute> groupData;
}
