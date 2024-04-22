import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { IssuesComponent } from './view/issues/issues.component';
import { NgbNav, NgbNavContent, NgbNavItem, NgbNavLink, NgbNavOutlet, NgbNavModule } from '@ng-bootstrap/ng-bootstrap';
import { DashboardComponent } from './view/dashboard/dashboard.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive, IssuesComponent, DashboardComponent,
    NgbNavOutlet, NgbNavItem, NgbNavLink, NgbNavContent, NgbNavModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  active = 'dashboard';
  title = 'issuetracker';
  constructor(public route: ActivatedRoute) { }
}
