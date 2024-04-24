import { Component, Input, OnInit } from '@angular/core';
import { IssuesComponent } from '../issues/issues.component';
import { ActivatedRoute } from '@angular/router';
import { Project, ProjectsService } from '../../api';
import { CommonModule } from '@angular/common';
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
  constructor(private projectService:ProjectsService,
    private route:ActivatedRoute
  ) {}
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(id != null && !isNaN(Number(id))) {
      this.id = Number(id);
    }
    this.projectService.getProjectById(this.id!)
      .subscribe(project => this.project = project);
  }
  
  @Input() id?:number;
}
