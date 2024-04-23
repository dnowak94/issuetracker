package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TaskStatus
 */
public enum TaskStatus {
  TODO("todo"),
  WORK_IN_PROGRESS("work_in_progress"),
  DONE("done");

  private String value;

  TaskStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TaskStatus fromValue(String text) {
    for (TaskStatus b : TaskStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
