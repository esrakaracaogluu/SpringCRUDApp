package com.esra.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class Jobs {
	@Id
	@SequenceGenerator(name = "job_seq", sequenceName = "jobs_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_seq")
	@Column(name = "JOB_ID")
	private String jobs_id;

	@Column(name = "JOB_TITLE")
	private String job_title;

	@Column(name = "MIN_SALARY")
	private int min_salary;

	@Column(name = "MAX_SALARY")
	private int max_salary;

	@OneToMany(mappedBy = "jobs", cascade = CascadeType.ALL)
	private List<Employees> employee;

	public String getJobs_id() {
		return jobs_id;
	}

	public void setJobs_id(String jobs_id) {
		this.jobs_id = jobs_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public int getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}

	public int getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}

	public List<Employees> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employees> employee) {
		this.employee = employee;
	}


	public Jobs() {
		super();
	}

}
