package com.example.issuetracker.api;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.issuetracker.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}