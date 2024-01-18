package com.example.issuetracker.repositories;

import com.example.issuetracker.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IssueRepository extends CrudRepository<Issue, Long> {
    @Override
    Optional<Issue> findById(Long aLong);
}
