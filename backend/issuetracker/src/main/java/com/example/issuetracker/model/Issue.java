package com.example.issuetracker.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import jakarta.annotation.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name ="description")
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Issue() {
        this.title = "";
        this.description = "";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Issue(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }
}
