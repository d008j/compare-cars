package com.demo.comparecars.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.util.Pair;

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
