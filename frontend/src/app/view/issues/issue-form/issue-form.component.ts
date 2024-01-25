import { Component, Input, OnInit, Optional } from '@angular/core';
import { Issue } from '../../../model/Issue';
import { FormsModule, NgModel } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { IssuesService } from '../../../services/issues.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-issue-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './issue-form.component.html',
  styleUrl: './issue-form.component.scss'
})
export class IssueFormComponent implements OnInit {
  issue: Issue = new Issue("", "");
  constructor(private route: ActivatedRoute,
    private issuesService: IssuesService
  ) { }

  ngOnInit(): void {
    this.getIssue();
  }

  getIssue(): void {
    // if id in parameters then get issue by id
    let paramId = this.route.snapshot.paramMap.get('id');
    if (paramId) {
      let id = Number(paramId);
      this.issuesService.getIssue(id)
        .subscribe(issue => this.issue = issue);
    }
  }

  onSubmit() {
    if (this.issue) {
      this.issuesService.updateIssue(this.issue)
        .subscribe(() => console.log("issue with id=", this.issue?.id, " updated."));
    }
  }
}
