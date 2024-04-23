package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets IssueStatus
 */
public enum IssueStatus {
  UNRESOLVED("unresolved"),
  RESOLVED("resolved"),
  WORK_IN_PROGRESS("work_in_progress");

  private String value;

  IssueStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static IssueStatus fromValue(String text) {
    for (IssueStatus b : IssueStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
