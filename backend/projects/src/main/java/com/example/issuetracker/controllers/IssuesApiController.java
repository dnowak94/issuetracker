package com.example.issuetracker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.api.IssueService;
import com.example.issuetracker.rest.api.IssuesApi;
import com.example.issuetracker.rest.model.IssueDTO;
import com.example.issuetracker.rest.model.IssueStatusDTO;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EntityNotFoundException;


@RestController
public class IssuesApiController implements IssuesApi {
	
	private final IssueService issueService;
	
	public IssuesApiController(IssueService issueService) {
		super();
		this.issueService = issueService;
	}
	
	@Override
	@GetMapping("/projects/{projectId}/issues")
	public ResponseEntity<List<IssueDTO>> getIssues(@PathVariable Long projectId, @javax.validation.Valid IssueStatusDTO statusDto) {
		Optional<IssueStatusDTO> status = statusDto != null ? Optional.of(statusDto): Optional.empty();
		List<IssueDTO> issues = this.issueService.findAll(status);
		return ResponseEntity.ok(issues);
	}
	
	@Override
	@GetMapping("/projects/{projectId}/issues/{issueId}")
	public ResponseEntity<IssueDTO> getIssue(@PathVariable Long projectId, @PathVariable Long issueId) {
		try {
			IssueDTO issue = this.issueService.findById(issueId);
			return ResponseEntity.ok(issue);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	@PostMapping("/projects/{projectId}/issues")
	public ResponseEntity<IssueDTO> createIssue(@PathVariable Long projectId, @javax.validation.Valid IssueDTO issueDTO) {
		IssueDTO createdIssue = this.issueService.syncIssue(projectId, issueDTO);
		return ResponseEntity.created(null).body(createdIssue);
	}

	@Override
	@PutMapping("/projects/{projectId}/issues/{issueId}")
	public ResponseEntity<Void> updateIssue(@PathVariable Long projectId, @PathVariable Long issueId, @javax.validation.Valid IssueDTO issueDTO) {
		this.issueService.syncIssue(projectId, issueDTO);
		return ResponseEntity.noContent().build();
	}

	@Override
	@DeleteMapping("/projects/{projectId}/issues/{issueId}")
    public ResponseEntity<Void> deleteIssue(
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required = true, schema = @Schema()) @PathVariable("issueId") Long issueId) {
        try {
        	this.issueService.deleteIssue(issueId);
        	return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
        	return ResponseEntity.notFound().build();
        } catch (Exception e) {
        	return ResponseEntity.badRequest().build();
        }
    }
}
