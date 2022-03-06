package com.demo.comparecars.controller;


import com.demo.comparecars.data.Car;
import com.demo.comparecars.data.ScoreConfig;
import com.demo.comparecars.service.CarService;
import com.demo.comparecars.service.ScoreConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/score-config")
public class ScoreConfigController {

    @Autowired
    ScoreConfigService scoreConfigService;

    @PostMapping({"/"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody ScoreConfig obj) {
        return ResponseEntity.ok(scoreConfigService.save(obj));
    }

    @GetMapping({"/"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(scoreConfigService.getAll());
    }

    @DeleteMapping({"/{referenceId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable("referenceId") String referenceId) {
        scoreConfigService.delete(referenceId);
        return ResponseEntity.noContent().build();
    }


}
