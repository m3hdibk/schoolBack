/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 2/27/20, 4:23 PM
 */

package com.school.demo.util.converter;

import com.school.demo.util.Constants;

import javax.persistence.AttributeConverter;

public class FeeCategoryConverter implements AttributeConverter<Constants.EFee, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Constants.EFee eFee) {
        return eFee.getLevelCode();
    }

    @Override
    public Constants.EFee convertToEntityAttribute(Integer levelCode) {
        return Constants.EFee.valueOfLevelCode(levelCode);
    }
}
