import { Component } from '@angular/core';

import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { ProjectsService } from '../../api/generated/projects';
import { Project } from '../../api/generated/projects/model/project';

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
