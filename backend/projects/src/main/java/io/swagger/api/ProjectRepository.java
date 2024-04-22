package io.swagger.api;

import org.springframework.data.repository.CrudRepository;

import io.swagger.model.Project;

public interface ProjectRepository extends CrudRepository<Long, Project>{
    
}
