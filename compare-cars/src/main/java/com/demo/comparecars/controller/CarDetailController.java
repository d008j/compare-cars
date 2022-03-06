package com.demo.comparecars.controller;


import com.demo.comparecars.data.Car;
import com.demo.comparecars.data.CarComparisonRequest;
import com.demo.comparecars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarDetailController {

    @Autowired
    CarService carService;

    @PostMapping({"/"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Car obj) {
        return ResponseEntity.ok(carService.save(obj));
    }

    @GetMapping({"/"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(carService.getAll());
    }

    @DeleteMapping({"/{referenceId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable("referenceId") String referenceId) {
        carService.delete(referenceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping({"/similarCars"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> similarCars(@RequestParam("id") String referenceId) {
        return ResponseEntity.ok(carService.findSimilarCars(referenceId));

    }

//    todo exception
    @PostMapping({"/compareCars"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> compareCars(@RequestBody CarComparisonRequest request) throws IllegalAccessException {
        return ResponseEntity.ok(carService.compareCars(request));

    }
}
