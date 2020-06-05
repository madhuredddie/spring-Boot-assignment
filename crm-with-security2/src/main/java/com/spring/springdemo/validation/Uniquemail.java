package com.spring.springdemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//import springMVC.validation.UniversityCodeConstraintValidator;

@Constraint(validatedBy=UniquemailConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Uniquemail {
	  public String value() ;
	
	public String message() default " Email Already exits,try another emailid";
	
	public Class<?>[] groups() default {};
	
	public Class<?extends Payload>[] payload() default {};

}
