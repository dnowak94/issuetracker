package com.example.issuetracker.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.issuetracker.entities.Task;
import com.example.issuetracker.rest.model.TaskStatusDTO;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findAllByStatus(TaskStatusDTO status);
}
