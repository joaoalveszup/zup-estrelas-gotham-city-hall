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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_project", columnDefinition = "serial")
	private Long idProject;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Double cost;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_secretariat", foreignKey=@ForeignKey(name="FK_ID_SECRETARIAT_PROJECT"))
    private Secretariat secretariat;
	
    @Column(nullable = false)
	private LocalDate startingDate;
    
    @Column(nullable = false)
	private LocalDate finishingDate;
	
    @Column(nullable = false)
	private boolean isFinished;

    // Getters and Setters
    
	public Long getIdProject() {
		return idProject;
	}

	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}

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

	public Secretariat getSecretariat() {
		return secretariat;
	}

	public void setSecretariat(Secretariat secretariat) {
		this.secretariat = secretariat;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDate getFinishingDate() {
		return finishingDate;
	}

	public void setFinishingDate(LocalDate finishingDate) {
		this.finishingDate = finishingDate;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}   
}
