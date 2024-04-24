package io.swagger.api;


import io.swagger.model.Project;
import io.swagger.model.Issue;
import io.swagger.model.Task;
import io.swagger.model.IssueStatus;
import io.swagger.model.TaskStatus;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProjectsRepository extends CrudRepository<Project, Long> {
}