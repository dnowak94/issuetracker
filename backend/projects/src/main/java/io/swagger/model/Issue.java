package io.swagger.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;

/**
 * Issue
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-22T19:17:38.806531302Z[GMT]")
@Entity
public class Issue {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
  private long id;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("status")
  @Enumerated(EnumType.STRING)
  private IssueStatus status = IssueStatus.UNRESOLVED;

  @JsonProperty("createdAt")
  private OffsetDateTime createdAt = OffsetDateTime.now();

  @JsonProperty("updatedAt")
  private OffsetDateTime updatedAt = OffsetDateTime.now();

  public Issue id(Long id) {
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

  public Issue title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * 
   * @return title
   **/
  @Schema(description = "")

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

  public Issue status(IssueStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * 
   * @return status
   **/
  @Schema(description = "")

  @jakarta.validation.Valid
  public IssueStatus getStatus() {
    return status;
  }

  public void setStatus(IssueStatus status) {
    this.status = status;
  }

  public Issue createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * 
   * @return createdAt
   **/
  @Schema(description = "")

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

  /**
   * Get updatedAt
   * 
   * @return updatedAt
   **/
  @Schema(description = "")

  @Valid
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
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
