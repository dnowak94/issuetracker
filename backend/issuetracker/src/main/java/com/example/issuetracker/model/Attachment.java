package com.example.issuetracker.model;

import jakarta.persistence.*;

@Entity(name = "Attachment")
@Table(name ="attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column(name ="attachment", columnDefinition = "BLOB")
    private byte[] attachment;
	@ManyToOne
    @JoinColumn(name = "issue_id",
			foreignKey = @ForeignKey(name = "ISSUE_ID_FK")
	)
    private Issue issue;
}
