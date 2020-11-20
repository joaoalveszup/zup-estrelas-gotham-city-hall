package br.com.zup.estrelas.gothamcityhall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.gothamcityhall.dto.CreateProjectDTO;
import br.com.zup.estrelas.gothamcityhall.dto.DoneProjectDTO;
import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.dto.UpdateProjectDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Project;
import br.com.zup.estrelas.gothamcityhall.entity.Secretariat;
import br.com.zup.estrelas.gothamcityhall.repository.ProjectRepository;
import br.com.zup.estrelas.gothamcityhall.repository.SecretariatRepository;

@Service
public class ProjectService implements IProjectService {

    private static final String DOES_NOT_EXIST = "THIS PROJECT DOES NOT EXIST";
    private static final String SECRETARIAT_DOES_NOT_EXIST = "THIS SECRETARIAT DOES NOT EXIST";
    private static final String SUCCESSFULLY_CREATED = "THE PROJECT WAS SUCCESSFULLY CREATED";
    private static final String SUCESSFULLY_UPDATED = "THE PROJECT WAS SUCCESSFULLY UPDATED";
    private static final String SUCESSFULLY_FINISHED = "THE PROJECT WAS SUCCESSFULLY FINISHED";
    private static final String INSUFFICIENT_PROJECT_BUDGET = "THE SECRETARIAT HAS NO BUDGET TO ACCEPT THIS PROJECT";
    private static final String INVALID_DATE = "THE DATE MUST BE AFTER THE STARTING PROJECT DATE";

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    SecretariatRepository secretariatRepository;

    public ResponseDTO createProject(CreateProjectDTO projectDTO) {

        Optional<Secretariat> secretariat = secretariatRepository.findById(projectDTO.getSecretariat());
        if (secretariat.isEmpty()) {
            return new ResponseDTO(SECRETARIAT_DOES_NOT_EXIST);
        }

        Secretariat analizedSecretariat = secretariat.get();
        boolean isProjectBudgetSufficient = analizedSecretariat.getProjectBudget() - projectDTO.getCost() >= 0;

        if (!isProjectBudgetSufficient) {
            return new ResponseDTO(INSUFFICIENT_PROJECT_BUDGET);
        }

        this.adjustsProjectBudgetWhenProjectCreated(analizedSecretariat, projectDTO);

        this.storesProject(analizedSecretariat, projectDTO);

        return new ResponseDTO(SUCCESSFULLY_CREATED);
    }

    public Project readProject(Long idProject) {
        return projectRepository.findById(idProject).orElse(null);
    }

    public List<Project> listProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    public ResponseDTO updateProject(Long idProject, UpdateProjectDTO projectDTO) {

        Optional<Project> project = projectRepository.findById(idProject);
        if (project.isEmpty()) {
            return new ResponseDTO(DOES_NOT_EXIST);
        }

        Project analizedProject = project.get();

        this.storesUpdatedProjectDescription(analizedProject, projectDTO);

        return new ResponseDTO(SUCESSFULLY_UPDATED);
    }

    public ResponseDTO finishProject(Long idProject, DoneProjectDTO projectDTO) {

        Optional<Project> project = projectRepository.findById(idProject);

        if (project.isEmpty()) {
            return new ResponseDTO(DOES_NOT_EXIST);
        }

        Project analizedProject = project.get();

        boolean isFinishingDateValid = projectDTO.getFinishingDate().isAfter(analizedProject.getStartingDate());
        if (!isFinishingDateValid) {
            return new ResponseDTO(INVALID_DATE);
        }

        this.storeFinishedProject(analizedProject, projectDTO);

        return new ResponseDTO(SUCESSFULLY_FINISHED);
    }

    private void storesProject(Secretariat secretariat, CreateProjectDTO projectDTO) {

        Project project = new Project();

        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setCost(projectDTO.getCost());
        project.setSecretariat(secretariat);

        projectRepository.save(project);

    }

    private void storesUpdatedProjectDescription(Project updatedProject, UpdateProjectDTO projectDTO) {

        updatedProject.setDescription(projectDTO.getDescription());
        projectRepository.save(updatedProject);

    }

    private void storeFinishedProject(Project updatedProject, DoneProjectDTO projectDTO) {

        updatedProject.setFinishingDate(projectDTO.getFinishingDate());
        updatedProject.setFinished(true);

        projectRepository.save(updatedProject);

    }

    private void adjustsProjectBudgetWhenProjectCreated(Secretariat secretariat, CreateProjectDTO projectDTO) {

        secretariat.setProjectBudget(secretariat.getProjectBudget() - projectDTO.getCost());
        secretariatRepository.save(secretariat);

    }

}
