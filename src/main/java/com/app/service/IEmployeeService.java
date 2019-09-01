package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeService {

	//copy methods from IEmpoyeeDao
	public Integer saveEmployee(Employee e);
	public List<Employee>  getAllEmployees();
	public void deleteEmployee(Integer id);
	public Employee getEmployeeById(Integer id);
	public void updateEmployee(Employee e);
}
