import { CommonModule, DatePipe } from '@angular/common';
import { Component, Input, OnInit, TemplateRef, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { bootstrapJournalPlus, bootstrapPencil, bootstrapTrash } from '@ng-icons/bootstrap-icons';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { environment } from '../../../environments/environment';
import { Issue } from '../../api/generated/projects';
import { IssuesService } from '../../api/generated/projects/api/issues.service';
@Component({
  selector: 'app-issues',
  templateUrl: './issues.component.html',
  styleUrl: './issues.component.scss',
  standalone: true,
  imports: [
    CommonModule, NgIconComponent, RouterLink, DatePipe
  ],
  providers: [provideIcons({bootstrapTrash, bootstrapPencil, bootstrapJournalPlus})]
})

export class IssuesComponent implements OnInit {
  issues: Issue[] = [];
  @Input() projectId?: number;
  constructor(private issuesService: IssuesService) { }
  private modalService = inject(NgbModal);
  
  ngOnInit(): void {
    this.getIssues();
  }

  getIssues(): void {
    console.log('url: ', environment.PROJECT_SERVICE);
    this.issuesService.getIssues(this.projectId!)
      .subscribe(issues => this.issues = issues);
  }

  getDeleteModalTitle(issue:Issue) {
    return `delete issue '${issue.title}'`;
  }

  getDeleteModalMessage(issue:Issue) {
    return `Are you sure you want to delete issue '${issue.title}'`;
  }

  onDeleteClick(deleteModal: TemplateRef<any>, issue:Issue) {
    this.modalService.open(deleteModal).result.then(
      (result) => {
        if(result === 'delete') {
          this.issuesService.deleteIssue(this.projectId!, issue.id!, "body", false)
          .subscribe(
            _ => {
              console.log(`issue with id=${issue.id} deleted.`);
              this.getIssues();
            }
          );
        }
      }
    )
  }
}
