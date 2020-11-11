package br.com.zup.estrelas.gothamcityhall.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.zup.estrelas.gothamcityhall.enums.Department;

@Entity
@Table(name = "secretariat")
public class Secretariat {

	@Id
	@Column(name = "id_secretariat")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSecretariat;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@Column(name = "project_budget", nullable = false)
	private Double projectBudget;
	
	@Column(name = "payroll_budget", nullable = false)
	private Double payrollBudget;
	
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String site;
	
	@Column(nullable = false)
	private String email;
	
	@OneToMany
	@JoinColumn(name = "id_secretariat")
	private List<Employee> employees;
	
	@OneToMany
	@JoinColumn(name = "id_secretariat")
	private List<Project> projects;

	// Getters and Setters
	
	public Long getIdSecretariat() {
		return idSecretariat;
	}

	public void setIdSecretariat(Long idSecretariat) {
		this.idSecretariat = idSecretariat;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Double getProjectBudget() {
		return projectBudget;
	}

	public void setProjectBudget(Double projectBudget) {
		this.projectBudget = projectBudget;
	}

	public Double getPayrollBudget() {
		return payrollBudget;
	}

	public void setPayrollBudget(Double payrollBudget) {
		this.payrollBudget = payrollBudget;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
