/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 2/24/20, 2:02 PM
 */

package com.school.demo.repositories;

import com.school.demo.model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails,Long> {

        Optional<LoginDetails> findByUsername(String username);

        Boolean existsByUsername(String username);

        Boolean existsByEmail(String email);

}
