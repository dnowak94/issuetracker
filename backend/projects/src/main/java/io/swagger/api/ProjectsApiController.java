package io.swagger.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Issue;
import io.swagger.model.IssueStatus;
import io.swagger.model.Project;
import io.swagger.model.Task;
import io.swagger.model.TaskStatus;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-22T19:17:38.806531302Z[GMT]")
@RestController("/projects")
public class ProjectsApiController implements ProjectsApi {

    private static final Logger log = LoggerFactory.getLogger(ProjectsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private ProjectsRepository repository;

    public ProjectsApiController(ProjectsRepository repository, ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.repository = repository;
    }

    public ResponseEntity<Project> addProject(
            @Parameter(in = ParameterIn.DEFAULT, description = "Create a new project", required = true, schema = @Schema()) @Valid @RequestBody Project body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            this.repository.save(body);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Project>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Issue> createIssue(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to get issues from", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Issue body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            if (project.isPresent()) {
                project.get().addIssuesItem(body);
                this.repository.save(project.get());
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        }

        return new ResponseEntity<Issue>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Task> createTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to get issues from", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Task body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            if (project.isPresent()) {
                project.get().addTasksItem(body);
                this.repository.save(project.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Task>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<String> deleteIssue(
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required = true, schema = @Schema()) @PathVariable("issueId") Long issueId) {
        Optional<Project> project = this.repository.findById(projectId);
        if (project.isPresent()) {
            Issue issue = this.getIssueById(projectId, issueId);
            if (issue != null) {
                project.get().getIssues().remove(issue);
                this.repository.save(project.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(String.format("issue with id=%s not found!", issueId), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(String.format("project with id=%s not found!", projectId), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the task that needs to be deleted", required = true, schema = @Schema()) @PathVariable("taskId") Long taskId) {
        Optional<Project> project = this.repository.findById(projectId);
        if (project.isPresent()) {
            Task task = this.getTaskById(projectId, taskId);
            if (task != null) {
                project.get().getTasks().remove(task);
                this.repository.save(project.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(String.format("task with id=%s not found!", taskId), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(String.format("project with id=%s not found!", projectId), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteproject(
            @Parameter(in = ParameterIn.PATH, description = "project id to delete", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId) {
        String accept = request.getHeader("Accept");
        Optional<Project> project = this.repository.findById(projectId);
        if (project.isPresent()) {
            this.repository.deleteById(projectId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("Project not found!", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Iterable<Project>> findAllProjects() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Iterable<Project> projects = this.repository.findAll();
            return new ResponseEntity<Iterable<Project>>(projects, HttpStatus.OK);
        }
        return new ResponseEntity<Iterable<Project>>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Issue> getIssue(
            @Parameter(in = ParameterIn.PATH, description = "ID of the project", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue", required = true, schema = @Schema()) @PathVariable("issueId") Long issueId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            if (project.isPresent()) {
                Issue issue = getIssueById(projectId, issueId);
                if (issue != null) {
                    return new ResponseEntity<>(issue, HttpStatus.OK);
                }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<List<Issue>> getIssues(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to get issues from", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.QUERY, description = "can be used to filter by issue status", schema = @Schema()) @Valid @RequestParam(value = "status", required = false) String status) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            if (project.isPresent()) {
                List<Issue> issues = project.get().getIssues();
                if (status != null) {
                    issues = issues.stream().filter(issue -> issue.getStatus().equals(IssueStatus.fromValue(status))).toList();
                }
                return new ResponseEntity<>(issues, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Project> getProjectById(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to return", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            if (project.isPresent()) {
                return new ResponseEntity<>(project.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Project>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Task> getTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of the project", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the task", required = true, schema = @Schema()) @PathVariable("taskId") Long taskId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            if (project.isPresent()) {
                Optional<Task> task = project.get().getTasks().stream().filter(x -> x.getId().equals(taskId))
                        .findFirst();
                return new ResponseEntity<>(task.get(), HttpStatus.OK);
            }
        }

        return new ResponseEntity<Task>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<List<Task>> getTasks(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to get tasks from", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.QUERY, description = "for filtering by task status", schema = @Schema()) @Valid @RequestParam(value = "status", required = false) String status) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            if (project.isPresent()) {
                List<Task> tasks = project.get().getTasks();
                if (status != null) {
                    tasks = tasks.stream().filter(task -> task.getStatus().equals(TaskStatus.fromValue(status))).toList();
                }
                return new ResponseEntity<>(tasks, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Void> updateIssue(
            @Parameter(in = ParameterIn.PATH, description = "ID of the project", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue", required = true, schema = @Schema()) @PathVariable("issueId") Long issueId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Issue body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            Issue issue = getIssueById(projectId, issueId);
            if (issue != null) {
                issue.updateIssue(body);
                this.repository.save(project.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
    }

    private Issue getIssueById(long projectId, long issueId) {
        Optional<Project> project = this.repository.findById(projectId);
        if (project.isPresent()) {
            Optional<Issue> issue = project.get().getIssues().stream().filter(x -> x.getId().equals(issueId))
                    .findFirst();
            return issue.orElse(null);
        }
        return null;
    }

    private Task getTaskById(long projectId, long taskId) {
        Optional<Project> project = this.repository.findById(projectId);
        if (project.isPresent()) {
            Optional<Task> task = project.get().getTasks().stream().filter(x -> x.getId().equals(taskId)).findFirst();
            return task.orElse(null);
        }
        return null;
    }

    public ResponseEntity<Void> updateProjectWithForm(
            @Parameter(in = ParameterIn.PATH, description = "ID of project that needs to be updated", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.DEFAULT, description = "Updates a project", required = true, schema = @Schema()) @Valid @RequestBody Project body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            if (project.isPresent()) {
                this.repository.save(body);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Task> updateTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of the project", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the task", required = true, schema = @Schema()) @PathVariable("taskId") Long taskId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Task body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.repository.findById(projectId);
            if (project.isPresent()) {
                Task task = getTaskById(projectId, taskId);
                if (task != null) {
                    task.updateTask(body);
                }
                this.repository.save(project.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
