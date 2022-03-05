package com.demo.comparecars.data;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "score_config")
public class ScoreConfig {

    @Id
    private long id;
    private String fieldName;
    private int score;

}
