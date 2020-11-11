package br.com.zup.estrelas.gothamcityhall.enums;

public enum Department {

	CULTURE("culture"),
	HEALTH("health"),
	EDUCATION("education"),
	TOURISM("tourism"),
	ENVIRONMENT("environment");
	
	private String value;
	
	Department(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
