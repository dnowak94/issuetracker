package com.example.issuetracker.api;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.issuetracker.entities.Project;
import com.example.issuetracker.entities.Task;
import com.example.issuetracker.mapper.TaskMapper;
import com.example.issuetracker.rest.model.IssueStatusDTO;
import com.example.issuetracker.rest.model.TaskDTO;
import com.example.issuetracker.rest.model.TaskStatusDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {
	private final TaskRepository taskRepository;
	private final ProjectRepository projectRepository;
	private final TaskMapper taskMapper;
	

	public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository, TaskMapper taskMapper) {
		super();
		this.taskRepository = taskRepository;
		this.projectRepository = projectRepository;
		this.taskMapper = taskMapper;
	}
	
	public List<TaskDTO> findAll(Optional<TaskStatusDTO> status) {
		List<Task> tasks = new ArrayList<>();
		if(status.isPresent()) {
			tasks = this.taskRepository.findAllByStatus(status.get());
		} else {
			tasks = this.taskRepository.findAll();
		}
		return tasks
				.stream()
				.map(taskMapper::mapFromEntity)
				.toList();
	}
	
	public TaskDTO findById(Long taskId) throws EntityNotFoundException {
		Task task = this.taskRepository.findById(taskId).orElseThrow(EntityNotFoundException::new);
		return taskMapper.mapFromEntity(task);
	}
	
	public TaskDTO addTask(Long projectId, TaskDTO taskDto) {
		taskDto = taskDto.id(-1l)
				.createdAt(OffsetDateTime.now())
				.updatedAt(OffsetDateTime.now());
		if(taskDto.getStatus() == null) {
			taskDto.setStatus(TaskStatusDTO.TODO);
		}
		Task task = this.taskMapper.mapFromDto(taskDto);
		Project project = this.projectRepository.findById(projectId).orElseThrow(EntityNotFoundException::new);
		task.setProject(project);
		Task createdTask = this.taskRepository.save(task);
		return this.taskMapper.mapFromEntity(createdTask);
	}

	public TaskDTO updateTaskById(Long projectId, Long taskId, TaskDTO taskDto) {
		Task Task = this.taskRepository.findById(taskId).orElseThrow(EntityNotFoundException::new);
		Task updatedTask = this.taskMapper.partialUpdate(taskDto, Task);
		updatedTask.setUpdatedAt(OffsetDateTime.now());
		return this.taskMapper.mapFromEntity(this.taskRepository.save(updatedTask));
	}
	
	public void deleteTask(Long projectId, Long taskId) {
		Project project = this.projectRepository.findById(projectId).orElseThrow(EntityNotFoundException::new);
		Task task = this.taskRepository.findById(taskId).orElseThrow(EntityNotFoundException::new);
		project.removeTask(task);
	}
}
