export * from './issues.service';
import { IssuesService } from './issues.service';
export * from './projects.service';
import { ProjectsService } from './projects.service';
export * from './tasks.service';
import { TasksService } from './tasks.service';
export const APIS = [IssuesService, ProjectsService, TasksService];
