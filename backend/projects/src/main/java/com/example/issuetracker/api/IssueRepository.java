package com.example.issuetracker.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.issuetracker.entities.Issue;
import com.example.issuetracker.rest.model.IssueStatusDTO;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
	List<Issue> findAllByStatus(IssueStatusDTO status);
}
