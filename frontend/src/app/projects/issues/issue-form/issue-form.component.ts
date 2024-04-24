import { Component, Input, OnInit, Optional } from '@angular/core';
import { FormBuilder, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Issue, IssueStatus, IssuesService } from '../../../api';
import { EnumToArrayPipe } from '../../enum-to-array.pipe';
import { switchMap } from 'rxjs';

@Component({
  selector: 'app-issue-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './issue-form.component.html',
  styleUrl: './issue-form.component.scss'
})
export class IssueFormComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder,
    private issuesService: IssuesService
  ) { }

  id: number | undefined;
  @Input() projectId?: number;
  issue: Issue | undefined;
  eIssueStatus = IssueStatus;

  issueForm = this.formBuilder.group({
    title: new FormControl('', {nonNullable: true}),
    description: new FormControl('', { nonNullable: true }),
    status: new FormControl<IssueStatus>(IssueStatus.Unresolved, {nonNullable: true})
  });

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      const issueId = Number(id);
      this.id = issueId;
      this.issuesService.getIssue(this.projectId!, issueId, "body")
        .subscribe(issue => {
          console.log("Get issue(): ", JSON.stringify(issue));
          this.issueForm.patchValue(issue);
          this.issue = issue;
        });
    }
  }

  get f() { return this.issueForm.controls; }


  private saveIssue() {
    return this.id === undefined
      ? this.issuesService.createIssue(this.projectId!, this.issueForm.value, "body")
      : this.issuesService.updateIssue(this.projectId!, this.id!, this.issueForm.value, "body");
  }

  onSubmit() {
    if (this.issueForm.valid) {
      this.saveIssue()
        .subscribe({
          next: () => {
            console.log('Issue saved: ', JSON.stringify(this.issueForm.value));
            const urlSegments = this.router.parseUrl(this.router.url).root.children['primary'].segments;
            // go back to project
            const url = urlSegments.slice(0, -3);
            this.router.navigate(url.map((segment) => segment.path));
          },
          error: error => {
            console.log('Issue save error: ', error);
          }
        });
    }
  }
}
