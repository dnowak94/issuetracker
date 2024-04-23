package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Issue;
import io.swagger.model.Task;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Project
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-22T19:17:38.806531302Z[GMT]")
@Entity
public class Project {
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("issues")
    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<Issue> issues = null;

    @JsonProperty("tasks")
    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> tasks = null;

    public Project id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @Schema(example = "10", description = "")

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @Schema(required = true, description = "")
    @NotNull

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @Schema(description = "")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project issues(List<Issue> issues) {
        this.issues = issues;
        return this;
    }

    public Project addIssuesItem(Issue issuesItem) {
        if (this.issues == null) {
            this.issues = new ArrayList<Issue>();
        }
        this.issues.add(issuesItem);
        return this;
    }

    /**
     * Get issues
     *
     * @return issues
     **/
    @Schema(description = "")
    @Valid
    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public Project tasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public Project addTasksItem(Task tasksItem) {
        if (this.tasks == null) {
            this.tasks = new ArrayList<Task>();
        }
        this.tasks.add(tasksItem);
        return this;
    }

    /**
     * Get tasks
     *
     * @return tasks
     **/
    @Schema(description = "")
    @Valid
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(this.id, project.id) &&
                Objects.equals(this.name, project.name) &&
                Objects.equals(this.description, project.description) &&
                Objects.equals(this.issues, project.issues) &&
                Objects.equals(this.tasks, project.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, issues, tasks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Project {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    issues: ").append(toIndentedString(issues)).append("\n");
        sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public void updateProject(Project other) {
        this.name = other.name;
        this.description = other.description;
        this.tasks = new ArrayList<>(other.getTasks().size());
        other.getTasks().stream().forEach(task -> {
            this.tasks.add(task);
        });
        this.issues = new ArrayList<>(other.getIssues().size());
        other.getIssues().stream().forEach(issue -> {
            this.issues.add(issue);
        });
    }
}
