package com.example.issue_service.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.issue_service.model.Issue;

public interface IssueRepository extends CrudRepository<Issue, Long> {
    
}
