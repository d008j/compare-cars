package com.demo.comparecars.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "score_config")
@AllArgsConstructor
@NoArgsConstructor
public class ScoreConfig {

    @Id
    private String id;
    private String fieldName;
    private int score;

}
