/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 7:27 PM
 */

package com.school.demo.repositories;

import com.school.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
