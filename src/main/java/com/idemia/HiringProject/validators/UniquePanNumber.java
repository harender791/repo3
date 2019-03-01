package com.idemia.HiringProject.validators;



import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import  java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniquePanNumberValidator.class })
public @interface UniquePanNumber {

	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
