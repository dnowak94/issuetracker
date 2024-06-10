package com.example.issuetracker.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.issuetracker.entities.Project;
import com.example.issuetracker.mapper.ProjectMapper;
import com.example.issuetracker.rest.model.ProjectDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjectService {
	private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;
    
    public ProjectService(ProjectMapper projectMapper, ProjectRepository projectRepository) {
		super();
		this.projectMapper = projectMapper;
		this.projectRepository = projectRepository;
	}
    
    public List<ProjectDTO> findAll() {
		return this.projectRepository.findAll()
				.stream()
				.map(projectMapper::mapFromEntity)
				.toList();
	}
    
    public ProjectDTO syncProject(ProjectDTO projectDto) {
    	Long id =  projectDto.getId();
    	return projectMapper.mapFromEntity(this.projectRepository.existsById(id) ? updateProject(projectDto): addProject(projectDto));
    }
    
    private Project addProject(ProjectDTO projectDto) {
    	Project project = projectMapper.mapFromDto(projectDto);
		return projectRepository.save(project);
	}

	private Project updateProject(ProjectDTO projectDto) {
		Project project = projectRepository.findById(projectDto.getId()).orElseThrow(EntityNotFoundException::new);
		Project updatedProject = projectMapper.partialUpdate(projectDto, project);
		return projectRepository.save(updatedProject);
	}

	public ProjectDTO findById(Long id) throws EntityNotFoundException {
    	return projectMapper.mapFromEntity(this.projectRepository.findById(id)
    			.orElseThrow(EntityNotFoundException::new));
    }

	public void deleteProject(Long projectId) throws EntityNotFoundException{
		projectRepository.findById(projectId).orElseThrow(EntityNotFoundException::new);
		projectRepository.deleteById(projectId);
	}
}
