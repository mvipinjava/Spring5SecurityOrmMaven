package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveEmployee(Employee e) {
		return (Integer) ht.save(e);	
	}
	@Override
	public List<Employee> getAllEmployees() {
		//select * from emptab
		//No.of rows = No.of Object (Stored in List)
		return ht.loadAll(Employee.class);
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		//Delete method will take Object having PK
		ht.delete(new Employee(id));
	}
	@Override
	public Employee getEmployeeById(Integer id) {
		return ht.get(Employee.class, id);
	}
	
	@Override
	public void updateEmployee(Employee e) {
		ht.update(e);
	}
}




