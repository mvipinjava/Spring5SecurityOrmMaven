package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeDao {

	//This method take Form Object and return PK 
	public Integer saveEmployee(Employee e);
	//Fetch All DB Rows
	public List<Employee>  getAllEmployees();
	//remove row based on Id
	public void deleteEmployee(Integer id);
	//fetch row based on ID
	public Employee getEmployeeById(Integer id);
	//update data 
	public void updateEmployee(Employee e);
	
}



