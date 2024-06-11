package io.swagger.api;

import io.swagger.model.Issue;
import io.swagger.model.Project;
import io.swagger.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-22T18:16:58.732407772Z[GMT]")
@RestController
public class ProjectsApiController implements ProjectsApi {

    private static final Logger log = LoggerFactory.getLogger(ProjectsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private ProjectsRepository projectRepository;
    private IssuesRepository issuesRepository;
    private TasksRepository tasksRepository;

    public ProjectsApiController(ObjectMapper objectMapper, HttpServletRequest request, 
    ProjectsRepository projectRepository, IssuesRepository issuesRepository, TasksRepository tasksRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.projectRepository = projectRepository;
        this.issuesRepository = issuesRepository;
        this.tasksRepository = tasksRepository;
    }

    public ResponseEntity<Project> addProject(@Parameter(in = ParameterIn.DEFAULT, description = "Create a new project", required=true, schema=@Schema()) @Valid @RequestBody Project body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Project>(objectMapper.readValue("{\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"id\" : 10\n}", Project.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Issue> createIssue(@Parameter(in = ParameterIn.PATH, description = "ID of project to get issues from", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Issue body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Issue>(objectMapper.readValue("{\n  \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"description\" : \"description\",\n  \"id\" : 10,\n  \"title\" : \"title\",\n  \"status\" : \"resolved\",\n  \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Issue.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Issue>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Issue>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Task> createTask(@Parameter(in = ParameterIn.PATH, description = "ID of project to get issues from", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Task body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Task>(objectMapper.readValue("{\n  \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"description\" : \"description\",\n  \"id\" : 10,\n  \"title\" : \"title\",\n  \"status\" : \"todo\",\n  \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Task.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteIssue(@Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
,@Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required=true, schema=@Schema()) @PathVariable("issueId") Long issueId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTask(@Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
,@Parameter(in = ParameterIn.PATH, description = "ID of the task that needs to be deleted", required=true, schema=@Schema()) @PathVariable("taskId") Long taskId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteproject(@Parameter(in = ParameterIn.PATH, description = "project id to delete", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Iterable<Project>> findAll() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Iterable<Project> projects = this.projectRepository.findAll();
            if(projects != null) {
                return new ResponseEntity<Iterable<Project>>(projects, HttpStatus.OK);
            } 
        }
        return new ResponseEntity<Iterable<Project>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Issue> getIssue(@Parameter(in = ParameterIn.PATH, description = "ID of the project", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
,@Parameter(in = ParameterIn.PATH, description = "ID of the issue", required=true, schema=@Schema()) @PathVariable("issueId") Long issueId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Issue> issue = this.issuesRepository.findById(issueId);
            if(issue.isPresent()) {
                return new ResponseEntity<Issue>(issue.get(), HttpStatus.OK);
            }
            return new ResponseEntity<Issue>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Issue>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Issue>> getIssues(@Parameter(in = ParameterIn.PATH, description = "ID of project to get issues from", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Issue> issues = this.issuesRepository.findById(projectId);
            if(issues != null) {
                return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
            }
        }

        return new ResponseEntity<List<Issue>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Project> getProjectById(@Parameter(in = ParameterIn.PATH, description = "ID of project to return", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Project> project = this.projectRepository.findById(projectId);
            if(project.isPresent()) {
                return new ResponseEntity<Project>(project.get(), HttpStatus.OK);
            }
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Task> getTask(@Parameter(in = ParameterIn.PATH, description = "ID of the project", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
,@Parameter(in = ParameterIn.PATH, description = "ID of the task", required=true, schema=@Schema()) @PathVariable("taskId") Long taskId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Project project = getProjectById(projectId).getBody();
            if(project != null) {
                Optional<Task> task = this.projectRepository.getTasks()
            }

        }

        return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Task>> getTasks(@Parameter(in = ParameterIn.PATH, description = "ID of project to get tasks from", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Task>>(objectMapper.readValue("[ {\n  \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"description\" : \"description\",\n  \"id\" : 10,\n  \"title\" : \"title\",\n  \"status\" : \"todo\",\n  \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\"\n}, {\n  \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"description\" : \"description\",\n  \"id\" : 10,\n  \"title\" : \"title\",\n  \"status\" : \"todo\",\n  \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Task>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Task>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateIssue(@Parameter(in = ParameterIn.PATH, description = "ID of the project", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
,@Parameter(in = ParameterIn.PATH, description = "ID of the issue", required=true, schema=@Schema()) @PathVariable("issueId") Long issueId
,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Issue body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateProjectWithForm(@Parameter(in = ParameterIn.PATH, description = "ID of project that needs to be updated", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
,@Parameter(in = ParameterIn.DEFAULT, description = "Updates a project", required=true, schema=@Schema()) @Valid @RequestBody Project body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Task> updateTask(@Parameter(in = ParameterIn.PATH, description = "ID of the project", required=true, schema=@Schema()) @PathVariable("projectId") Long projectId
,@Parameter(in = ParameterIn.PATH, description = "ID of the task", required=true, schema=@Schema()) @PathVariable("taskId") Long taskId
,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Task body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Task>(objectMapper.readValue("{\n  \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"description\" : \"description\",\n  \"id\" : 10,\n  \"title\" : \"title\",\n  \"status\" : \"todo\",\n  \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Task.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
    }

}
