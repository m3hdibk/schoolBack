/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 2/23/20, 4:01 PM
 */

package com.school.demo.util.converter;

import com.school.demo.util.Constants.ERole;

import javax.persistence.AttributeConverter;

public class UserRolesConverter implements AttributeConverter<ERole, Integer> {


    @Override
    public Integer convertToDatabaseColumn(ERole eRole) {
       return eRole.getLevelCode();
    }

    @Override
    public ERole convertToEntityAttribute(Integer levelCode) {
         return ERole.valueOfLevelCode(levelCode);
    }
}