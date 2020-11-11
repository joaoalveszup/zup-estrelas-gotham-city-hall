package br.com.zup.estrelas.gothamcityhall.dto;

import br.com.zup.estrelas.gothamcityhall.enums.Department;

public class SecretariatDTO {

	private Department department;

	private Double projectBudget;

	private Double payrollBudget;

	private String phoneNumber;

	private String address;

	private String site;

	private String email;

	// Getters and Setters

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

}
