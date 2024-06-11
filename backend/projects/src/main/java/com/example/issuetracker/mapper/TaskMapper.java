package com.example.issuetracker.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.issuetracker.entities.Task;
import com.example.issuetracker.rest.model.TaskDTO;

@Mapper(componentModel = "spring")
public interface TaskMapper {
	Task mapFromDto(TaskDTO taskDto);
	TaskDTO mapFromEntity(Task task);
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Task partialUpdate(TaskDTO taskDto, @MappingTarget Task task);
}
