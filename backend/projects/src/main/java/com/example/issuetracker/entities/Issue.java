package com.example.issuetracker.entities;

import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.example.issuetracker.rest.model.IssueStatusDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;

@Validated
@Entity
public class Issue {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title = "";

  private String description = "";

  @Enumerated(EnumType.STRING)
  private IssueStatusDTO status = IssueStatusDTO.UNRESOLVED;

  private OffsetDateTime createdAt = OffsetDateTime.now();

  private OffsetDateTime updatedAt = OffsetDateTime.now();
  
  @ManyToOne
  private Project project;

  public Issue id(Long id) {
    this.id = id;
    return this;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Issue title(String title) {
    this.title = title;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Issue description(String description) {
    this.description = description;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Issue status(IssueStatusDTO status) {
    this.status = status;
    return this;
  }

  @jakarta.validation.Valid
  public IssueStatusDTO getStatus() {
    return status;
  }

  public void setStatus(IssueStatusDTO status) {
    this.status = status;
  }

  public Issue createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  @Valid
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Issue updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Valid
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Project getProject() {
	return project;
}

public void setProject(Project project) {
	this.project = project;
}

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Issue issue = (Issue) o;
    return Objects.equals(this.id, issue.id) &&
        Objects.equals(this.title, issue.title) &&
        Objects.equals(this.description, issue.description) &&
        Objects.equals(this.status, issue.status) &&
        Objects.equals(this.createdAt, issue.createdAt) &&
        Objects.equals(this.updatedAt, issue.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, status, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Issue {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

  public void updateIssue(Issue other) {
    this.title = other.title;
    this.description = other.description;
    this.status = other.status;
    this.updatedAt = OffsetDateTime.now();
  }
}
