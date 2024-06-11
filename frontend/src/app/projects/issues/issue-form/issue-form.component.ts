import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, map, switchMap } from 'rxjs';
import { Issue, IssueStatus, IssuesService } from '../../../api/generated/projects';
import { SharedModule } from '../../../shared/shared.module';

@Component({
  selector: 'app-issue-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, SharedModule],
  templateUrl: './issue-form.component.html',
  styleUrl: './issue-form.component.scss'
})
export class IssueFormComponent implements OnInit {
  @Input() issue$: Observable<Issue>;
  @Output() issueSubmit = new EventEmitter();
  issueForm$: Observable<FormGroup>;
  eIssueStatus = IssueStatus;

  constructor(private formBuilder:FormBuilder) {
    this.issue$ = new Observable<Issue>();
    this.issueForm$ = new Observable<FormGroup>();
  }

  ngOnInit(): void {
    this.issueForm$ = this.issue$.pipe(
        map(issue => {
          const { title, description, status, createdAt, updatedAt } = issue;
          return this.formBuilder.group({
            id: issue.id,
            title: new FormControl(title, [
              Validators.required
            ]),
            description: new FormControl(description, [
              Validators.required
            ]),
            status: new FormControl<IssueStatus>(status!, [
              Validators.required
            ]),
            createdAt: createdAt,
            updatedAt: updatedAt
          });
        })
    );
  }


  onSubmit(form:FormGroup) {
    if (form.invalid) {
      return;
    }
    this.issueSubmit.emit(form.value);
  }
}
