import { Routes } from '@angular/router';
import { IssuesComponent } from './view/issues/issues.component';
import { DashboardComponent } from './view/dashboard/dashboard.component';

export const routes: Routes = [
    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    { path: 'issues', component: IssuesComponent },
    { path: 'dashboard', component: DashboardComponent }
];
