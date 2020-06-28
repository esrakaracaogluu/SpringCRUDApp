package com.esra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.esra.dao.EmployeeDAO;
import com.esra.domain.Department;
import com.esra.domain.Employees;
import com.esra.domain.Jobs;
import com.esra.domain.Kullanici;
import com.esra.domain.Kurs;

@Service
public class EmployeeServisiImpl implements EmployeeServisi{
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
    @Transactional
    @Override
	public List<Employees> getCalisanlar() {
		return employeeDAO.getCalisanlar();
	}
    
    @Transactional
	@Override
	public List<Jobs> getJobsList() {
    	return employeeDAO.getJobsList();
 
	}

    @Transactional
	@Override
	public List<Department> getDepartmentList() {
		return employeeDAO.getDepartmentList();
	}
    
    @Transactional
   	@Override
   	public List<Department> getManagerList() {
   		return employeeDAO.getManagerList();
   	}
    
    @Transactional
	@Override
	public void saveEmployee(Employees employee) {
		employeeDAO.saveEmployee(employee);		
	}
	
    @Transactional
	@Override
	public void deleteEmployee(int empId) {
    	employeeDAO.deleteEmployee(empId);		
	}
    
    @Transactional
	@Override
	public Employees getEmployee(int empId) {
		return employeeDAO.getEmployee(empId);
	}

}
