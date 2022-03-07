package com.demo.comparecars.data;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@Builder
@AllArgsConstructor
public class CarAttribute {

    String name;
    boolean isDifferent;
    List<Pair> values;
}
