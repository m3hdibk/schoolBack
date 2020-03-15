/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 2/24/20, 12:23 PM
 */

package com.school.demo.repositories;

import com.school.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}