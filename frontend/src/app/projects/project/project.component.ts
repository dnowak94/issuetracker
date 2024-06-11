import { Component, Input, OnInit } from '@angular/core';
import { IssuesComponent } from '../issues/issues.component';
import { ActivatedRoute } from '@angular/router';
import { Project, ProjectsService } from '../../api/generated/projects';
import { CommonModule } from '@angular/common';
import { TasksComponent } from '../tasks/tasks.component';
import { switchMap } from 'rxjs';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrl: './project.component.scss',
  standalone: true,
  imports: [
    CommonModule, IssuesComponent, TasksComponent
  ]
})
export class ProjectComponent implements OnInit {
  project: Project | undefined;
  projectId?:number;
  constructor(private projectService:ProjectsService,
    private route:ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        this.projectId = Number(params.get('projectId'));
        return this.projectService.getProjectById(this.projectId);
      })
    )
    .subscribe(project => this.project = project);
  }
}
