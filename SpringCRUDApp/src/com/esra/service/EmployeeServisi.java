package com.esra.service;

import java.util.List;

import com.esra.domain.Department;
import com.esra.domain.Employees;
import com.esra.domain.Jobs;
import com.esra.domain.Kurs;

public interface EmployeeServisi {

	public List<Employees> getCalisanlar();

	public List<Jobs> getJobsList();

	public List<Department> getDepartmentList();

	public List<Department> getManagerList();

	public void saveEmployee(Employees employee);

	public void deleteEmployee(int empId);

	public Employees getEmployee(int empId);

}
