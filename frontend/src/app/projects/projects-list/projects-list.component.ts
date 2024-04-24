import { Component } from '@angular/core';
import { IssuesService, ProjectsService, TasksService } from '../../api';

import { Observable, map, take } from 'rxjs';
import { CommonModule } from '@angular/common';
import { Project } from '../../api/model/project';
import { IssueStatus } from '../../api/model/issueStatus';
import { TaskStatus } from '../../api/model/taskStatus';
import { Task } from '../../api/model/task';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-projects-list',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterOutlet],
  templateUrl: './projects-list.component.html',
  styleUrl: './projects-list.component.scss'
})
export class ProjectsListComponent {
  projects: Project[] = [];
  constructor(
    private projectsService: ProjectsService,
    private issuesService: IssuesService,
    private tasksService: TasksService
  ) { }

  ngOnInit(): void {
    this.getProjects();
  }
  getProjects(): void {
    let projects = this.projectsService.findAll(IssueStatus.Unresolved, TaskStatus.Todo)
    .subscribe(
      projects => this.projects = projects
    );
  }

  getOpenIssues(projectId: number): any {
    this.issuesService.getIssues(projectId, IssueStatus.Unresolved, 'body')
      .subscribe(issues => {
        return issues;
      });
  }

  getOpenTasks(projectId: number): any {
    let result: Task[] = [];
    this.tasksService.getTasks(projectId, TaskStatus.Todo, 'body')
      .subscribe(tasks => {
        return tasks;
      });
  }
}
