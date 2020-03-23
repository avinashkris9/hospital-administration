package org.allsafeclinic.hospitaladministration.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GenderValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsValidGender {


    Class<? extends Enum<?>>enumClass();
    String message() default ErrorCodes.INVALID_GENDER;
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
