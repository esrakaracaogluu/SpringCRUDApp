package com.esra.dao;

import java.util.List;

import com.esra.domain.Department;
import com.esra.domain.Employees;
import com.esra.domain.Jobs;

public interface EmployeeDAO {
	public List<Employees> getCalisanlar();

	public List<Jobs> getJobsList();

	public void saveEmployee(Employees employee);

	public List<Department> getDepartmentList();

	public List<Department> getManagerList();

	public void deleteEmployee(int empId);

	public Employees getEmployee(int empId);

}
