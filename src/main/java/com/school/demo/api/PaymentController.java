/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:23 PM
 */

package com.school.demo.api;


import com.school.demo.model.Payment;
import com.school.demo.model.data.PaymentData;
import com.school.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PaymentController {


    @Autowired
    PaymentRepository paymentRepository;


    @GetMapping("/payments")
    public ResponseEntity<List<PaymentData>> getAllPayment() {


        try {
            List<PaymentData> payments = paymentRepository.findAll().stream().map(Payment::convertToDataObject).collect(Collectors.toList());
            if (payments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(payments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/payment")
    ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        try {
            Payment payment1 = paymentRepository.save(payment);
            return new ResponseEntity<>(payment1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
