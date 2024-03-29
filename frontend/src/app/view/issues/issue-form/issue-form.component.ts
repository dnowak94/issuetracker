import { Component, Input, OnInit, Optional } from '@angular/core';
import { Issue } from '../../../model/Issue';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { IssuesService } from '../../../services/issues.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-issue-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './issue-form.component.html',
  styleUrl: './issue-form.component.scss'
})
export class IssueFormComponent implements OnInit {
  @Input() id?: string;
  @Input() issue:Issue | undefined;
  issueForm = this.formBuilder.group({
    id: [0],
    title: ['', Validators.required],
    description: [''],
    createdAt: [new Date()],
    updatedAt: [new Date()]
  });

  loading:boolean = false;
  submitted:boolean = false;
  title!: string;
  

  constructor(
    private router:Router,
    private issuesService: IssuesService, 
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.getIssue();
  }

  get f() { return this.issueForm.controls; }

  private getIssue():void {
    
    if (this.id !== null) {
      let id = Number(this.id);
      this.issuesService.getIssue(id)
        .subscribe(issue => {
          this.issueForm.patchValue(issue);
          this.loading = false;
        });
    }
  }

  private saveIssue() {
    return this.id      
      ? this.issuesService.createIssue(this.issueForm.value)
      : this.issuesService.updateIssue(this.issueForm.value);
  }

  onSubmit() {
    this.submitted = true;
    if (this.issueForm.valid) {
      this.saveIssue()
      .subscribe({
        next: () => {
          console.log('Issue saved: ', JSON.stringify(this.issueForm.value));
          this.router.navigateByUrl('/issues');
        },
        error: error => {
          console.log('Issue save error: ', error);          
        }
      });
    }
  }
}
