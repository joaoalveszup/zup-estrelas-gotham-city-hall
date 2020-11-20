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
// TODO: Gabriel, aqui eu consigo compreender por quê tratou o projects
// como um recurso independente, mas dado que ele só pode pertencer à uma
// secretaria e isso não muda, seria interessante tratá-lo como um subrecurso
// de secretaria, seu endpoint seria algo como:
// /secretariats/{id}/projects. Dê uma olhada na referência do portal
// desenvolvimento para entender melhor por quê isso faz mas sentido como um subrecurso
// e qualquer dúvida pode falar comigo.
public class ProjectController {

    @Autowired
    IProjectService projectService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO createProject(@RequestBody CreateProjectDTO project) {
        return projectService.createProject(project);
    }

    @GetMapping(path = "/{idProject}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Project readProject(@PathVariable Long idProject) {
        return projectService.readProject(idProject);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Project> listSecretariat() {
        return projectService.listProjects();
    }

    // FIXME: Gabriel, se você quiser indicar uma operação na URL,
    // normalmente o identificador do recurso vem antes. Acredito
    // que aqui poderia ser um put convencional.
    @PutMapping(path = "/descriptions/{idProject}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO updateProject(@PathVariable Long idProject,
            @RequestBody UpdateProjectDTO project) {
        return projectService.updateProject(idProject, project);
    }

    // FIXME: Eu acredito que pra finalização faria mais sentido ter alguma info
    // na URL, tipo /{idProject}/finish, como no exemplo do star na referência de REST que
    // passei pra vocês.
    @PutMapping(path = "/{idProject}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO finishProject(@PathVariable Long idProject,
            @RequestBody DoneProjectDTO project) {
        return projectService.finishProject(idProject, project);
    }

}
