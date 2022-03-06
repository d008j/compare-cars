package com.demo.comparecars.service;

import com.demo.comparecars.data.ScoreConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScoreConfigService {

    ScoreConfig save(ScoreConfig scoreConfig);
    List<ScoreConfig> getAll();
    ScoreConfig update(ScoreConfig scoreConfig);
    void delete(String id);

}
