package com.esra.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
	@Id
	@SequenceGenerator(name = "dep_seq", sequenceName = "departments_seq", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_seq")
	@Column(name = "DEPARTMENT_ID")
	private int departmentId;

	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MANAGER_ID")
	private Employees manager;

	@Column(name = "LOCATION_ID")
	private Integer locationId;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Employees> departmentList;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	public List<Employees> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Employees> departmentList) {
		this.departmentList = departmentList;
	}

	public Department(String departmentName, Employees manager, Integer locationId, List<Employees> departmentList) {
		super();
		this.departmentName = departmentName;
		this.manager = manager;
		this.locationId = locationId;
		this.departmentList = departmentList;
	}

	public Department() {
		super();
	}

}
