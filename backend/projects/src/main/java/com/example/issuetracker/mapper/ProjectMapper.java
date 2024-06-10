package com.example.issuetracker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.issuetracker.entities.Project;
import com.example.issuetracker.rest.model.ProjectDTO;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

   Project mapFromDto(ProjectDTO projectDto);

   ProjectDTO mapFromEntity(Project projectBase);
   Project partialUpdate(ProjectDTO projectDto, @MappingTarget Project project);
}
