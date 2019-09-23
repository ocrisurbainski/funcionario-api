package br.com.urbainski.backend.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.urbainski.backend.validation.validators.NisValidator;

/**
 * 
 * @author Cristian Urbainski
 * @since 20/09/2019
 *
 */
@Documented
@Constraint(validatedBy = NisValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Nis {

	String message() default "{javax.validation.constraints.Nis.message}";
	
	Class<?>[] groups() default {};
	
    Class<? extends Payload>[] payload() default {};
	
}