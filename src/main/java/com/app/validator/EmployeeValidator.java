package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Employee;

@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		//Target cast to Model class obejct
		//It is Form Object
		Employee e=(Employee)target;
		
		if(!Pattern.matches("[A-Z]{2,4}", e.getEmpName())) {
			errors.rejectValue("empName", null,"Please Enter valid Name!!");
		}
		
		//If Null or lessthen zero - reject
		if(e.getEmpSal()==null || e.getEmpSal()<=0) {
			errors.rejectValue("empSal", null,"Please Enter Valid Salary!!");
		}
		
		//drop down data validation.
		if("".equals(e.getEmpDept())) {
			errors.rejectValue("empDept", null,"Please select one Dept!!");
		}
		
		//radio button check
		//Not null, Not Empty, no space chars
		if(!StringUtils.hasText(e.getEmpGen())) {
			errors.rejectValue("empGen", null,"Please Choose one Gender!!");
		}
		
		//text area (not null,not empty, no space
		//min 10 char
		if(!StringUtils.hasText(e.getEmpAddr())
			|| e.getEmpAddr().length() < 10	
				)
		{
			errors.rejectValue("empAddr", null,"Enter 10 Chars atleast!!");
		}
	}
}