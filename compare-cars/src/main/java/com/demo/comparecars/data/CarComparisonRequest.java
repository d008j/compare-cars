package com.demo.comparecars.data;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
public class CarComparisonRequest {

    String baseCarId;
    List<String> otherIds;
    boolean showOnlyDifference;

}
