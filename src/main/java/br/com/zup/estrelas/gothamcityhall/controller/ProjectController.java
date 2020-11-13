package br.com.zup.estrelas.gothamcityhall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.gothamcityhall.dto.CreateProjectDTO;
import br.com.zup.estrelas.gothamcityhall.dto.DoneProjectDTO;
import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.dto.UpdateProjectDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Project;
import br.com.zup.estrelas.gothamcityhall.service.IProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectService projectService;
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO createProject(@RequestBody CreateProjectDTO project) {
		return projectService.createProject(project);
	}
	
	@GetMapping(path = "/{idProject}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Project readProject(@PathVariable Long idProject) {
		return projectService.readProject(idProject);
	}
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Project> listSecretariat() {
		return projectService.listProjects();
	}
	
	@PutMapping(path = "/descriptions/{idProject}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO updateProject(@PathVariable Long idProject, @RequestBody UpdateProjectDTO project) {
		return projectService.updateProject(idProject, project);
	}
	
	@PutMapping(path = "/{idProject}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO finishProject(@PathVariable Long idProject, @RequestBody DoneProjectDTO project) {
		return projectService.finishProject(idProject, project);
	}
	
}
