package br.com.zup.estrelas.gothamcityhall.dto;

public class EmployeeDTO {

	private String name;
	
	private String cpf;
	
	private Double salary;
	
    private Long secretariat;
	
    private String role;
    
    private boolean isPermanent;

    // Getters and Setters
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getSecretariat() {
		return secretariat;
	}

	public void setSecretariat(Long secretariat) {
		this.secretariat = secretariat;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}
	
}
