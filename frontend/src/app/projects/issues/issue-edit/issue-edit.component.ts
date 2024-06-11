import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TaskFormComponent } from '../../tasks/task-form/task-form.component';
import { Issue, IssuesService } from '../../../api/generated/projects';
import { ActivatedRoute } from '@angular/router';
import { Observable, switchMap } from 'rxjs';
import { IssueFormComponent } from '../issue-form/issue-form.component';

@Component({
  selector: 'app-issue-edit',
  templateUrl: './issue-edit.component.html',
  styleUrl: './issue-edit.component.css',
  standalone: true,
  imports: [
    CommonModule, IssueFormComponent
  ]
})
export class IssueEditComponent implements OnInit {
  issue$: Observable<Issue>;
  projectId?:number;
  constructor(private route:ActivatedRoute, private issuesService:IssuesService) {
    this.issue$ = this.route.paramMap.pipe(
      switchMap((params) => {
        this.projectId = Number(params.get('projectId'));
        const issueId = Number(params.get('issueId'));
        return this.issuesService.getIssue(this.projectId, issueId);
      })
    );
  }

  ngOnInit(): void {
    
  }

  onSubmit(issue:Issue) {
    this.issuesService.updateIssue(this.projectId!, issue.id!, issue)
    .subscribe((response) => {
      console.log(response);
    });
  }
}
