package br.com.zup.estrelas.gothamcityhall.dto;

public class CreateProjectDTO {

	private String name;
	
	private String description;
	
	private Double cost;
	
	private Long secretariat;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public Long getSecretariat() {
		return secretariat;
	}
	
	public void setSecretariat(Long secretariat) {
		this.secretariat = secretariat;
	}
	
}
