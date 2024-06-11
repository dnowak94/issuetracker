import { Component } from '@angular/core';

import { Observable, map, take } from 'rxjs';
import { CommonModule } from '@angular/common';
import { Project } from '../../api/generated/projects/model/project';
import { IssueStatus } from '../../api/generated/projects/model/issueStatus';
import { TaskStatus } from '../../api/generated/projects/model/taskStatus';
import { Task } from '../../api/generated/projects/model/task';
import { RouterLink, RouterOutlet } from '@angular/router';
import { IssuesService, ProjectsService, TasksService } from '../../api/generated/projects';

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
    private projectsService: ProjectsService
  ) { }

  ngOnInit(): void {
    this.getProjects();
  }
  getProjects(): void {
    this.projectsService.findAll()
    .subscribe(
      projects => this.projects = projects
    );
  }
}
