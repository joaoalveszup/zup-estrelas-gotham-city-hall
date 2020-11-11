package br.com.zup.estrelas.gothamcityhall.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_employee", columnDefinition = "serial")
	private Long idEmployee;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private Double salary;
	
	@ManyToOne
	@JoinColumn(name = "id_secretariat", foreignKey=@ForeignKey(name="FK_ID_SECRETARIAT"))
    private Secretariat secretariat;
	
    @Column(nullable = false)
    private String role;
    
    @Column(nullable = false)
    private boolean isPermanent;
    
    @Column(nullable = false)
    private LocalDate startingDate;

    // Getters and Setters
    
	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

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

	public Secretariat getSecretariat() {
		return secretariat;
	}

	public void setSecretariat(Secretariat secretariat) {
		this.secretariat = secretariat;
	}

	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isPermanentEmployee() {
		return isPermanent;
	}

	public void setPermanentEmployee(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}
}
