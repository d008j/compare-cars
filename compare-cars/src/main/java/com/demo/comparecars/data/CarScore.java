package com.demo.comparecars.data;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@Builder
@EqualsAndHashCode(cacheStrategy = EqualsAndHashCode.CacheStrategy.LAZY)
public class CarScore implements  Comparable<CarScore>{

    private Car car;
    private int score;
    private int hashCode;

    @Override
    public int compareTo(CarScore anotherCarScore) {
        return -1 * Integer.compare(this.score, anotherCarScore.score);
    }


}
