package com.example.issuetracker.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.api.TaskService;
import com.example.issuetracker.rest.api.TasksApi;
import com.example.issuetracker.rest.model.TaskDTO;
import com.example.issuetracker.rest.model.TaskStatusDTO;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EntityNotFoundException;

@RestController
public class TasksApiController implements TasksApi {
	
	private final Logger logger = LoggerFactory.getLogger(TasksApiController.class);

	private final TaskService taskService;
	
	public TasksApiController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	@Override
	@GetMapping("/projects/{projectId}/tasks")
	public ResponseEntity<List<TaskDTO>> getTasks(Long projectId, @javax.validation.Valid TaskStatusDTO statusDto) {
		Optional<TaskStatusDTO> status = statusDto != null ? Optional.of(statusDto) : Optional.empty();
		return ResponseEntity.ok(this.taskService.findAll(status));
	}
	
	@Override
	@GetMapping("/projects/{projectId}/tasks/{taskId}")
	public ResponseEntity<TaskDTO> getTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of the project", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the task", required = true, schema = @Schema()) @PathVariable("taskId") Long taskId) {
		try {
			TaskDTO task = this.taskService.findById(taskId);
			return ResponseEntity.ok(task);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
    }
	
	@Override
	@PostMapping("/projects/{projectId}/tasks")
	public ResponseEntity<TaskDTO> createTask(Long projectId, TaskDTO taskDTO) {
		try {
			TaskDTO createdTask = this.taskService.addTask(projectId, taskDTO);
			return ResponseEntity.created(null).body(createdTask);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}
	
    @Override
    @PutMapping("/projects/{projectId}/tasks/{taskId}")
	public ResponseEntity<TaskDTO> updateTask(Long projectId, Long taskId, @javax.validation.Valid TaskDTO taskDTO) {
    	try {
    		TaskDTO updatedTask = this.taskService.updateTaskById(projectId, taskId, taskDTO);
    		return ResponseEntity.ok(updatedTask);
    	} catch (EntityNotFoundException e) {
    		return ResponseEntity.notFound().build();
    	} catch (Exception e) {
    		logger.error(e.getMessage());
			return ResponseEntity.internalServerError().build();
    	}
	}
    
    @Override
    @DeleteMapping("projects/{projectId}/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the task that needs to be deleted", required = true, schema = @Schema()) @PathVariable("taskId") Long taskId) {
        try {
        	this.taskService.deleteTask(projectId, taskId);
        	return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
        	return ResponseEntity.notFound().build();
        } catch (Exception e) {
        	logger.error(e.getMessage());
        	return ResponseEntity.internalServerError().build();
        }
    }
}
