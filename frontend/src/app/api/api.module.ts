import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { IssuesService } from './generated/projects/api/issues.service';
import { ProjectsService } from './generated/projects/api/projects.service';
import { TasksService } from './generated/projects/api/tasks.service';

@NgModule({
  imports:      [],
  declarations: [],
  exports:      [],
  providers: [
    IssuesService,
    ProjectsService,
    TasksService ]
})
export class ApiModule {}
