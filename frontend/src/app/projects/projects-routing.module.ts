import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectsHomeComponent } from './projects-home/projects-home.component';
import { ProjectComponent } from './project/project.component';
import { IssueFormComponent } from './issues/issue-form/issue-form.component';
import { TaskFormComponent } from './tasks/task-form/task-form.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { IssueCreateComponent } from './issues/issue-create/issue-create.component';
import { TaskCreateComponent } from './tasks/task-create/task-create.component';
import { IssueEditComponent } from './issues/issue-edit/issue-edit.component';
import { TaskEditComponent } from './tasks/task-edit/task-edit.component';

const routes: Routes = [
  { path: ':projectId/issues/create', component: IssueCreateComponent },
  { path: ':projectId/tasks/create', component: TaskCreateComponent },
  { path: ':projectId/issues/edit/:issueId', component: IssueEditComponent },
  { path: ':projectId/tasks/edit/:taskId', component: TaskEditComponent },
  { path: ':projectId', component: ProjectComponent },
  { path: 'not-found', component: NotFoundComponent },
  { path: '', component: ProjectsHomeComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectsRoutingModule { }
