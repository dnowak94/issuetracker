package com.example.issue_service.repositories;

import com.example.issue_service.model.Issue;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Long> {
    
}
