package com.example.issuetracker;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;

@Controller
@RequestMapping(path="/issues")
public class IssueController {
    @Autowired
    private IssueRepository issueRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Issue> getAll() {
        return this.issueRepository.findAll();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Issue> getById(@PathVariable Long id) {
        Optional<Issue> issue = issueRepository.findById(id);
        return issue.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Issue issue) {
        this.issueRepository.save(issue);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Issue issue) {
        this.issueRepository.save(issue);
    }
}
