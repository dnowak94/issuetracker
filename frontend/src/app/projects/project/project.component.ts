import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs';
import { Project, ProjectsService } from '../../api/generated/projects';
import { IssuesComponent } from '../issues/issues.component';
import { TasksComponent } from '../tasks/tasks.component';

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
