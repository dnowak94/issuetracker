package com.example.issuetracker.api;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.issuetracker.entities.Issue;
import com.example.issuetracker.entities.Project;
import com.example.issuetracker.mapper.IssueMapper;
import com.example.issuetracker.rest.model.IssueDTO;
import com.example.issuetracker.rest.model.IssueStatusDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class IssueService {
	private final IssueRepository issueRepository;
	private final ProjectRepository projectRepository;
	private final IssueMapper issueMapper;
	
	public IssueService(IssueRepository issueRepository, ProjectRepository projectRepository, IssueMapper issueMapper) {
		super();
		this.issueRepository = issueRepository;
		this.projectRepository = projectRepository;
		this.issueMapper = issueMapper;
	}
	
	public IssueDTO findById(Long issueId) throws EntityNotFoundException {
		Issue issue = this.issueRepository.findById(issueId).orElseThrow(EntityNotFoundException::new);
		return issueMapper.mapFromEntity(issue);
	}
	
	public List<IssueDTO> findAll(Optional<IssueStatusDTO> status) {
		List<Issue> issues = new ArrayList<>();
		if(status.isPresent()) {
			issues = this.issueRepository.findAllByStatus(status.get());
		} else {
			issues = this.issueRepository.findAll();
		}
		return issues
				.stream()
				.map(issueMapper::mapFromEntity)
				.toList();
	}
	
	 public IssueDTO syncIssue(Long projectId, IssueDTO issueDto) {
    	Long id =  issueDto.getId();
    	return issueMapper.mapFromEntity(id != null && this.issueRepository.existsById(id) ? updateIssue(projectId, id, issueDto): addIssue(projectId, issueDto));
    }
	
	private Issue addIssue(Long projectId, IssueDTO issueDto) throws EntityNotFoundException {
		issueDto = issueDto.id(-1l)
				.createdAt(OffsetDateTime.now())
				.updatedAt(OffsetDateTime.now());
		if(issueDto.getStatus() == null) {
			issueDto.setStatus(IssueStatusDTO.UNRESOLVED);
		}
		
		Issue issue = issueMapper.mapFromDto(issueDto);
		Project project = this.projectRepository.findById(projectId).orElseThrow(EntityNotFoundException::new);
		issue.setProject(project);
		return issueRepository.save(issue);
	}

	private Issue updateIssue(Long projectId, Long issueId, IssueDTO issueDto) {
		Issue issue = issueRepository.findById(issueId).orElseThrow(EntityNotFoundException::new);
		Issue updatedIssue = issueMapper.partialUpdate(issueDto, issue);
		return issueRepository.save(updatedIssue);
	}
	
	public void deleteIssue(Long issueId) throws EntityNotFoundException {
		this.issueRepository.findById(issueId).orElseThrow(EntityNotFoundException::new);
		this.issueRepository.deleteById(issueId);
	}
}
