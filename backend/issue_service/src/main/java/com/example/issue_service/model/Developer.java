package com.example.issue_service.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Developer")
@Table(name = "developer")
public class Developer extends User {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Issue> assignedIssues = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Issue> resolvedIssues = new ArrayList<>();
}
