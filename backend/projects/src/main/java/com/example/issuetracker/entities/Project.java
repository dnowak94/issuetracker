package com.example.issuetracker.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Project
 */
@Validated
@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id = null;
  
  @Column(columnDefinition = "varchar(255) default ''")
  private String name = "";

  @Column(columnDefinition = "text default ''")
  private String description = "";

  @Valid
  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
  private List<Issue> issues = new ArrayList<>();

  @JsonProperty("tasks")
  @Valid
  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
  private List<Task> tasks = new ArrayList<>();

  public Project id(Long id) {
    this.id = id;
    return this;
  }

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

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }
  
  public void addIssue(Issue issue) {
	    this.issues.add(issue);
	    issue.setProject(this);
  }
  
  public void removeIssue(Issue issue) {
	  this.issues.remove(issue);
	  issue.setProject(null);
  }
  
  @Override
public String toString() {
	return "Project [id=" + id + ", name=" + name + ", description=" + description + ", issues=" + issues + ", tasks="
			+ tasks + "]";
}

@Override
public int hashCode() {
	return Objects.hash(description, id, issues, name, tasks);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Project other = (Project) obj;
	return Objects.equals(description, other.description) && Objects.equals(id, other.id)
			&& Objects.equals(issues, other.issues) && Objects.equals(name, other.name)
			&& Objects.equals(tasks, other.tasks);
}

public void addTask(Task task) {
    this.tasks.add(task);
    task.setProject(this);
  }
  
  public void removeTask(Task task) {
	  this.tasks.remove(task);
	  task.setProject(null);
  }
}
