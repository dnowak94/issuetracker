package com.example.issuetracker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.issuetracker.entities.Issue;
import com.example.issuetracker.rest.model.IssueDTO;

@Mapper(componentModel = "spring")
public interface IssueMapper {
	Issue mapFromDto(IssueDTO issueDto);
	IssueDTO mapFromEntity(Issue issue);
	Issue partialUpdate(IssueDTO issueDto, @MappingTarget Issue issue);
}
