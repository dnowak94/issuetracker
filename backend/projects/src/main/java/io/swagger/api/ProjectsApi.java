/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.55).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Issue;
import io.swagger.model.Project;
import io.swagger.model.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-22T17:17:28.475276+02:00[Europe/Luxembourg]")
@Validated
public interface ProjectsApi {

    @Operation(summary = "Create a new project", description = "Add a new project", tags = { "projects" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Project.class))),

            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/projects", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.POST)
    ResponseEntity<Project> addProject(
            @Parameter(in = ParameterIn.DEFAULT, description = "Create a new project", required = true, schema = @Schema()) @Valid @RequestBody Project body);

    @Operation(summary = "Create an issue for a project", description = "Create a new issue for a project", tags = {
            "issues" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Issue.class))),

            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/projects/{projectId}/issues", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.POST)
    ResponseEntity<Issue> createIssue(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to get issues from", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Issue body);

    @Operation(summary = "Create an issue for a project", description = "Create a new issue for a project", tags = {
            "tasks" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))),

            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/projects/{projectId}/tasks", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.POST)
    ResponseEntity<Task> createTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to get issues from", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Task body);

    @Operation(summary = "Delete issue by ID", description = "", tags = { "issues" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "issue deleted successfully"),

            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

            @ApiResponse(responseCode = "404", description = "Issue not found") })
    @RequestMapping(value = "/projects/{projectId}/issues/{issueId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteIssue(
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required = true, schema = @Schema()) @PathVariable("issueId") Long issueId);

    @Operation(summary = "Delete task by ID", description = "", tags = { "tasks" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "task deleted successfully"),

            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

            @ApiResponse(responseCode = "404", description = "Task not found") })
    @RequestMapping(value = "/projects/{projectId}/tasks/{taskId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue that needs to be deleted", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the task that needs to be deleted", required = true, schema = @Schema()) @PathVariable("taskId") Long taskId);

    @Operation(summary = "Deletes a project", description = "delete a project", tags = { "projects" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid project value") })
    @RequestMapping(value = "/projects/{projectId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteproject(
            @Parameter(in = ParameterIn.PATH, description = "project id to delete", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId);

    @Operation(summary = "get issue by id", description = "", tags = { "issues" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Issue.class))) })
    @RequestMapping(value = "/projects/{projectId}/issues/{issueId}", produces = {
            "application/json" }, method = RequestMethod.GET)
    ResponseEntity<Issue> getIssue(
            @Parameter(in = ParameterIn.PATH, description = "ID of the project", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue", required = true, schema = @Schema()) @PathVariable("issueId") Long issueId);

    @Operation(summary = "lists all issues of the project with the specified id", description = "", tags = { "issues" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Issue.class)))) })
    @RequestMapping(value = "/projects/{projectId}/issues", produces = {
            "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<Issue>> getIssues(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to get issues from", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId);

    @Operation(summary = "Find project by ID", description = "Returns a single project", tags = { "projects" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Project.class))),

            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

            @ApiResponse(responseCode = "404", description = "project not found") })
    @RequestMapping(value = "/projects/{projectId}", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<Project> getProjectById(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to return", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId);

    @Operation(summary = "get task by id", description = "", tags = { "tasks" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))) })
    @RequestMapping(value = "/projects/{projectId}/tasks/{taskId}", produces = {
            "application/json" }, method = RequestMethod.GET)
    ResponseEntity<Task> getTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of the project", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the task", required = true, schema = @Schema()) @PathVariable("taskId") Long taskId);

    @Operation(summary = "lists all issues of the project with the specified id", description = "", tags = { "tasks" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Task.class)))) })
    @RequestMapping(value = "/projects/{projectId}/tasks", produces = {
            "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<Task>> getTasks(
            @Parameter(in = ParameterIn.PATH, description = "ID of project to get tasks from", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId);

    @Operation(summary = "update issue information", description = "", tags = { "issues" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfull operation") })
    @RequestMapping(value = "/projects/{projectId}/issues/{issueId}", consumes = {
            "application/json" }, method = RequestMethod.PUT)
    ResponseEntity<Void> updateIssue(
            @Parameter(in = ParameterIn.PATH, description = "ID of the project", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the issue", required = true, schema = @Schema()) @PathVariable("issueId") Long issueId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Issue body);

    @Operation(summary = "Updates a project with form data", description = "", tags = { "projects" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/projects/{projectId}", consumes = { "application/json" }, method = RequestMethod.PUT)
    ResponseEntity<Void> updateProjectWithForm(
            @Parameter(in = ParameterIn.PATH, description = "ID of project that needs to be updated", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.DEFAULT, description = "Updates a project", required = true, schema = @Schema()) @Valid @RequestBody Project body);

    @Operation(summary = "update task information", description = "", tags = { "tasks" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))) })
    @RequestMapping(value = "/projects/{projectId}/tasks/{taskId}", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.PUT)
    ResponseEntity<Task> updateTask(
            @Parameter(in = ParameterIn.PATH, description = "ID of the project", required = true, schema = @Schema()) @PathVariable("projectId") Long projectId,
            @Parameter(in = ParameterIn.PATH, description = "ID of the task", required = true, schema = @Schema()) @PathVariable("taskId") Long taskId,
            @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Task body);

}
