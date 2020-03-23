package org.allsafeclinic.hospitaladministration.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenderValidation implements ConstraintValidator<IsValidGender,String>
{

    private List<String> acceptedValues;
    @Override
    public void initialize(IsValidGender constraintAnnotation) {
        acceptedValues= Stream.of(constraintAnnotation.enumClass().getEnumConstants())
                .map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String gender, ConstraintValidatorContext context) {
        return acceptedValues.contains((gender));

    }
}
