import { Component, OnInit } from '@angular/core';
import { IssuesComponent } from '../issues/issues.component';
import { Issue } from '../../model/Issue';
import { IssuesService } from '../../services/issues.service';
import { isIdentifier } from '@angular/compiler';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [IssuesComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {
  issues:Issue[] = [];
  constructor(private issuesService:IssuesService) {}
  ngOnInit(): void {
    this.getIssues();
  }
  getIssues():void {
    this.issuesService.getIssues()
    .subscribe(
      issues => this.issues = issues.slice(1,5)
    );
  }
}
