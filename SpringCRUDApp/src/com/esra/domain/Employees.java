package com.esra.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {

	@Id
	@Column(name = "EMPLOYEE_ID")
	@SequenceGenerator(name = "seq_employees", sequenceName = "EMPLOYEES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employees")
	private Integer employeeId;

	@Column(name = "FIRST_NAME")
	@NotEmpty(message = "Ýsim girilmesi zorunludur!")
	private String first_name;

	@Column(name = "LAST_NAME")
	@NotEmpty(message = "Soyisim girilmesi zorunludur!")
	private String last_name;

	@Column(name = "EMAIL")
	private String email;
	
	@Size(min=1,max=11,message="Numara girilmesi zorunludur!")
	@Column(name = "PHONE_NUMBER")
	private String phone_number;

	@Column(name = "HIRE_DATE")
	private Date hire_date;

	@ManyToOne
	@JoinColumn(name = "JOB_ID")
	private Jobs jobs;

	@Column(name = "SALARY")
	private int salary;

	@Column(name = "COMMISSION_PCT")
	private Double commission_pct;

	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employees manager;

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Double getCommission_pct() {
		return commission_pct;
	}

	public void setCommission_pct(Double commission_pct) {
		this.commission_pct = commission_pct;
	}

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employees(String first_name, String last_name, String email, String phone_number, Date hire_date, Jobs jobs,
			int salary, Double commission_pct, Employees manager, Department department) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.jobs = jobs;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.manager = manager;
		this.department = department;
	}

	public Employees() {
		super();
	}

}
