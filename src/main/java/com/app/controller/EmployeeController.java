package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.validator.EmployeeValidator;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	@Autowired
	private EmployeeValidator validator;

	//1. Show Register Page
	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("employee",new Employee());
		return "EmployeeRegister";
	}

	//2. validate and save data in DB
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(
			@ModelAttribute Employee employee,
			Errors errors,
			ModelMap map
			) 
	{
		//do data validation
		validator.validate(employee, errors);

		//checl for errors exist
		if(!errors.hasErrors()) {
			//no errors
			//perform save operations
			Integer id=service.saveEmployee(employee);
			map.addAttribute("message", "Employee '"+id+"' saved");
			//Clear Form Data
			map.addAttribute("employee", new Employee());
		}else { //errors exist
			//return back to same package with error msg
			map.addAttribute("message", "Please Check all Errors");
		}


		return "EmployeeRegister";
	}



	//3. Display data in UI Page
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		//fetch data from DB to List
		List<Employee> emps=service.getAllEmployees();
		//send to UI
		map.addAttribute("list",emps);
		return "EmployeeData";
	}


	//4. delete based on ID
	@RequestMapping("/delete")
	public String doDelete(
			@RequestParam Integer id
			)
	{
		service.deleteEmployee(id);
		//response.sendRedirect
		return "redirect:all";
	}


	//5. Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(
			@RequestParam Integer id,
			ModelMap map
			) 
	{
		//fetch data from DB (based on Id)
		//to Show in Edit Page
		Employee e=service.getEmployeeById(id);
		//Form Backing Object (Object==> Spring FORM)
		map.addAttribute("employee", e);
		return "EmployeeEdit";
	}

	//6. Update Employee
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String doUpdate(
			@ModelAttribute Employee employee)

	{
		service.updateEmployee(employee);
		//response.sendRedirect
		return "redirect:all";
	}


}
