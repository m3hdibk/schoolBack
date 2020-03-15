/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:01 PM
 */

package com.school.demo.api;

import com.school.demo.model.Fee;
import com.school.demo.repositories.FeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FeeController {


    private final FeeRepository feeRepository;

    public FeeController(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }


    @GetMapping("/fees")
    public ResponseEntity<List<Fee>> getAllFees(){
        try {
            List<Fee> lessons = new ArrayList<>(feeRepository.findAll());
            if (lessons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lessons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/fee")
    public ResponseEntity<Fee> createFee(@RequestBody Fee fee) {
        try {
            Fee payment1 = feeRepository.save(fee);
            return new ResponseEntity<>(payment1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
