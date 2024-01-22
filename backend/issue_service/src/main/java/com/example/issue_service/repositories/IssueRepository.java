package com.example.issue_service.repositories;

import com.example.issue_service.model.Issue;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IssueRepository extends CrudRepository<Issue, Long> {
    @Override
    Optional<Issue> findById(Long aLong);
}
