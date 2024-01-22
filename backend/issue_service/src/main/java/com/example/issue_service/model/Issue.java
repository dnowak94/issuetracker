package com.example.issue_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "Issue")
@Table(name = "issue")
public class Issue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name ="description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Issue() {
        this.title = "";
        this.description = "";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = Status.UNRESOLVED;
    }

    public Issue(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }
}
