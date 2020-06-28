package com.esra.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.esra.domain.Department;
import com.esra.domain.Employees;
import com.esra.domain.Jobs;
import com.esra.service.EmployeeServisi;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	EmployeeServisi employeeServisi;

	@GetMapping("/list")
	public String loginEkraný(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/";
		} else {
			List<Employees> calisanList = employeeServisi.getCalisanlar();
			model.addAttribute("calisan", calisanList);
			return "employees-list";
		}

	}

	@GetMapping("/employee-ekle")
	public String employeeEkle(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/";
		} else {

			Employees employee = new Employees();
			model.addAttribute("employee", employee);

			return "employees-form";
		}
	}

	@GetMapping("/employee-sil")
	public String employeeSil(@RequestParam("empId") int empId) {

		employeeServisi.deleteEmployee(empId);

		return "redirect:/employees/list";
	}

	@GetMapping("/employee-guncelle")
	public String employeeGuncelle(@RequestParam("empId") int empId, Model model) {
		Employees employee = employeeServisi.getEmployee(empId);
		model.addAttribute("employee", employee);
		return "employees-form";
	}

	@PostMapping("/employee-kaydet")
	public String employeeKaydet(@Valid @ModelAttribute("employee") Employees employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "employees-form";
		}
		employeeServisi.saveEmployee(employee);

		return "redirect:/employees/list";
	}

	@ModelAttribute("jobs")
	public Map<String, String> getJobs() {
		Map<String, String> jobs = new HashMap<String, String>();

		List<Jobs> jobsList = employeeServisi.getJobsList();
		for (Jobs job : jobsList) {
			jobs.put(job.getJobs_id(), job.getJob_title());
		}

		return jobs;
	}

	@ModelAttribute("departments")
	public Map<Integer, String> getDepartment() {
		Map<Integer, String> departments = new HashMap<Integer, String>();
		List<Department> departmentList = employeeServisi.getDepartmentList();
		for (Department department : departmentList) {
			departments.put(department.getDepartmentId(), department.getDepartmentName());
		}
		return departments;
	}

	@ModelAttribute("managers")
	public Map<Integer, String> getEmployee() {
		Map<Integer, String> managers = new HashMap<Integer, String>();
		List<Employees> employeeList = employeeServisi.getCalisanlar();

		for (Employees employees : employeeList) {
			managers.put(employees.getEmployeeId(), employees.getFirst_name());
		}
		return managers;
	}

}
