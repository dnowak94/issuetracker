import { Routes } from '@angular/router';
import { IssuesComponent } from './view/issues/issues.component';
import { DashboardComponent } from './view/dashboard/dashboard.component';
import { IssueFormComponent } from './view/issues/issue-form/issue-form.component';

export const routes: Routes = [
    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    { path: 'issues', component: IssuesComponent },
    { path: 'issues/:id', component: IssueFormComponent },
    { path: 'issues/create', component: IssueFormComponent },
    { path: 'dashboard', component: DashboardComponent }
];
