import { Component, OnInit } from '@angular/core';
import { Issue, IssueStatus, IssuesService } from '../../../api/generated/projects';
import { IssueFormComponent } from '../issue-form/issue-form.component';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subscriber, switchMap } from 'rxjs';

@Component({
  selector: 'app-issue-create',
  templateUrl: './issue-create.component.html',
  styleUrl: './issue-create.component.css',
  standalone: true,
  imports: [
    IssueFormComponent
  ]
})
export class IssueCreateComponent implements OnInit {
  issue$:Observable<Issue>;
  projectId?:number;

  constructor(private issuesService:IssuesService, private route:ActivatedRoute) {
    this.issue$ = new Observable<Issue>((subscriber) => {
      subscriber.next(
        {
          title: '',
          description: '',
          status: IssueStatus.Unresolved
        }
      );
    });
  }

  ngOnInit(): void {
      this.projectId = Number(this.route.snapshot.paramMap.get('projectId'));
  }

  onSubmit(issue:Issue) {
    this.route.paramMap.pipe(
      switchMap(params => {
        const projectId = Number(params.get('projectId'));
        return this.issuesService.createIssue(projectId, issue);
      })
    )
    .subscribe(response => console.log(response));
  }
}
