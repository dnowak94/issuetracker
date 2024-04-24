import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectsHomeComponent } from './projects-home/projects-home.component';
import { ProjectComponent } from './project/project.component';
import { IssueFormComponent } from './issues/issue-form/issue-form.component';
import { TaskFormComponent } from './task-form/task-form.component';

const routes: Routes = [
  { path: ':id/issues/create', component: IssueFormComponent },
  { path: ':id/tasks/create', component: TaskFormComponent },
  { path: ':projectId/issues/edit/:id', component: IssueFormComponent },
  { path: ':projectId/tasks/edit/:id', component: IssueFormComponent },
  { path: ':id', component: ProjectComponent },
  { path: '', component: ProjectsHomeComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectsRoutingModule { }
