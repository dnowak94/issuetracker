package com.example.issuetracker.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.api.ProjectService;
import com.example.issuetracker.rest.api.ProjectsApi;
import com.example.issuetracker.rest.model.ProjectDTO;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EntityNotFoundException;

@RestController
public class ProjectsApiController implements ProjectsApi {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectsApiController.class);

    private final ProjectService projectService;
    
    public ProjectsApiController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}
    
	@Override
	public ResponseEntity<List<ProjectDTO>> findAll() {
        List<ProjectDTO> projects = this.projectService.findAll();
        return ResponseEntity.ok(projects);
	}
    
    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
    	try {
    		return ResponseEntity.ok(this.projectService.findById(id));
    	} catch (EntityNotFoundException e) {
    		return ResponseEntity.notFound().build();
    	} catch (Exception e) {
    		logger.error(e.getMessage());
    		return ResponseEntity.internalServerError().build();
    	}
    }
 
	@Override
	@PostMapping
	public ResponseEntity<ProjectDTO> addProject(@javax.validation.Valid ProjectDTO projectDTO) {
		ProjectDTO createdProject = this.projectService.syncProject(projectDTO);
		return ResponseEntity.created(null).body(createdProject);
	}

	@Override
	@PutMapping("/projects/{projectId}")
	public ResponseEntity<Void> updateProjectWithForm(Long projectId, @javax.validation.Valid ProjectDTO projectDTO) {
		try {
			this.projectService.syncProject(projectDTO);
			return ResponseEntity.ok(null);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
   
    @DeleteMapping("/projects/{projectId}")
    @Override
    public ResponseEntity<Void> deleteProject(
            @Parameter(in = ParameterIn.PATH, description = "project id to delete", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId) {
        try {
            this.projectService.deleteProject(projectId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
        	return ResponseEntity.notFound().build();
        } catch (Exception e) {
        	logger.error(e.getMessage());
        	return ResponseEntity.badRequest().build();
        }
    }
}
