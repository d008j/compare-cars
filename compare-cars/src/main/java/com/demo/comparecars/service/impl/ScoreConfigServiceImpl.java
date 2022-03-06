package com.demo.comparecars.service.impl;


import com.demo.comparecars.data.ScoreConfig;
import com.demo.comparecars.repository.ScoreConfigRepository;
import com.demo.comparecars.service.ScoreConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ScoreConfigServiceImpl implements ScoreConfigService {

    @Autowired
    ScoreConfigRepository scoreConfigRepository;

    @Override
    public ScoreConfig save(ScoreConfig scoreConfig) {
        return scoreConfigRepository.save(scoreConfig);
    }

    @Override
    public List<ScoreConfig> getAll() {
        return  scoreConfigRepository.findAll();
    }

    @Override
    public ScoreConfig update(ScoreConfig scoreConfig) {
        return  scoreConfigRepository.save(scoreConfig);
    }

    @Override
    public void delete(String id) {
        ScoreConfig scoreConfig = scoreConfigRepository.findById(id).get();
        scoreConfigRepository.delete(scoreConfig);
        return;
    }
}
