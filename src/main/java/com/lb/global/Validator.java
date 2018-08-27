package com.lb.global;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class Validator {

	public static void validate(BindingResult result) {
		
		if (result.hasErrors()) {
			
			StringBuffer buffer = new StringBuffer();
			
			List<ObjectError> errors = result.getAllErrors();
			
			for (ObjectError objectError : errors) {
				
				buffer.append(objectError.getDefaultMessage());
				
			}
			
			throw new GlobalException(buffer.toString());
			
		}
		
	}

}
