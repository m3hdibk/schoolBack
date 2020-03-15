/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 7:15 PM
 */

package com.school.demo.repositories;

import com.school.demo.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepository extends JpaRepository<Fee, Long> {
}
