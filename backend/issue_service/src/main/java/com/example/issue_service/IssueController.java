package com.example.issue_service;

import com.example.issue_service.model.Issue;
import com.example.issue_service.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Optional;
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

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Issue issue) {
        issue.setUpdatedAt(LocalDateTime.now());
        this.issueRepository.save(issue);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        Optional<Issue> issue = this.issueRepository.findById(id);
        if(issue.isPresent()) {
            this.issueRepository.deleteById(id);
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>(String.format("issue with id=%s not found!", id), HttpStatus.NOT_FOUND);
    }
}
