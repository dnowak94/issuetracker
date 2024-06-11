package com.example.issue_service.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Developer")
@Table(name = "developer")
public class Developer extends User {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Issue> assignedIssues = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Issue> resolvedIssues = new ArrayList<>();
}
