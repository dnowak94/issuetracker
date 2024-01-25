import { DatePipe, NgFor } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { Issue } from '../../model/Issue';
import { IssuesService } from '../../services/issues.service';
import { environment } from '../../../environments/environment';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { bootstrapJournalPlus, bootstrapPencil } from '@ng-icons/bootstrap-icons'
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-issues',
  standalone: true,
  imports: [NgFor, DatePipe, NgIconComponent, RouterLink],
  providers: [provideIcons({bootstrapJournalPlus, bootstrapPencil })],
  templateUrl: './issues.component.html',
  styleUrl: './issues.component.scss'
})

export class IssuesComponent implements OnInit {
  @Input() issues: Issue[] = [];
  constructor(private issuesService: IssuesService) { }

  ngOnInit(): void {
    this.getIssues();
  }
  getIssues(): void {
    console.log('url: ', environment.ISSUES_URL);
    this.issuesService.getIssues()
      .subscribe(issues => this.issues = issues);
  }
}
