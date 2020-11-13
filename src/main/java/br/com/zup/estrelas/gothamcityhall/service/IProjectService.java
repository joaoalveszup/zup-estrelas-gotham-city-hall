package br.com.zup.estrelas.gothamcityhall.service;

import java.util.List;

import br.com.zup.estrelas.gothamcityhall.dto.CreateProjectDTO;
import br.com.zup.estrelas.gothamcityhall.dto.DoneProjectDTO;
import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.dto.UpdateProjectDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Project;

public interface IProjectService {

	public ResponseDTO createProject(CreateProjectDTO projectDTO);
	
	public Project readProject(Long idProject);
	
	public List<Project> listProjects();

	public ResponseDTO updateProject(Long idProject, UpdateProjectDTO projectDTO);
	
	public ResponseDTO finishProject(Long idProject, DoneProjectDTO projectDTO);
	
}
