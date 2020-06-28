package com.esra.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.esra.domain.Department;
import com.esra.domain.Employees;
import com.esra.domain.Jobs;
import com.esra.domain.Kurs;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Employees> getCalisanlar() {
		Session session = sessionFactory.getCurrentSession();
		Query<Employees> query = session.createQuery("from Employees", Employees.class);
		List<Employees> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public List<Jobs> getJobsList() {
		Session session = sessionFactory.getCurrentSession();
		Query<Jobs> query = session.createQuery("from Jobs", Jobs.class);
		List<Jobs> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public List<Department> getDepartmentList() {
		Session session = sessionFactory.getCurrentSession();
		Query<Department> query = session.createQuery("from Department", Department.class);
		List<Department> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public List<Department> getManagerList() {
		Session session = sessionFactory.getCurrentSession();
		Query<Department> query = session.createQuery("from Department", Department.class);
		List<Department> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public void saveEmployee(Employees employee) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(employee);
	}
	
	@Override
	public void deleteEmployee(int empId) {
		Session session = sessionFactory.getCurrentSession();

		Employees emp = session.get(Employees.class, empId);

		session.delete(emp);
	}

	@Override
	public Employees getEmployee(int empId) {
        Session session=sessionFactory.getCurrentSession();
		
        Employees emp=session.get(Employees.class, empId);
		
		return emp;
	}

}
