package io.swagger.api;

import io.swagger.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectsRepository extends CrudRepository<Project, Long> {
}