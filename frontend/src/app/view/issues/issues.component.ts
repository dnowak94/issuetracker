import { CommonModule, DatePipe, NgComponentOutlet, NgFor } from '@angular/common';
import { Component, Input, OnInit, TemplateRef, Type, inject } from '@angular/core';
import { Issue } from '../../model/Issue';
import { IssuesService } from '../../services/issues.service';
import { environment } from '../../../environments/environment';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { bootstrapJournalPlus, bootstrapPencil, bootstrapTrash } from '@ng-icons/bootstrap-icons'
import { RouterLink } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-issues',
  standalone: true,
  imports: [CommonModule, DatePipe, NgIconComponent, RouterLink, NgComponentOutlet],
  providers: [provideIcons({bootstrapJournalPlus, bootstrapPencil, bootstrapTrash })],
  templateUrl: './issues.component.html',
  styleUrl: './issues.component.scss'
})

export class IssuesComponent implements OnInit {
  @Input() issues: Issue[] = [];
  constructor(private issuesService: IssuesService) { }
  private modalService = inject(NgbModal);
  
  getDeleteModalTitle(issue:Issue) {
    return `delete issue '${issue.title}'`;
  }

  getDeleteModalMessage(issue:Issue) {
    return `Are you sure you want to delete issue '${issue.title}'`;
  }

  ngOnInit(): void {
    this.getIssues();
  }

  getIssues(): void {
    console.log('url: ', environment.ISSUES_URL);
    this.issuesService.getIssues()
      .subscribe(issues => this.issues = issues);
  }

  onDeleteClick(deleteModal: TemplateRef<any>, issue:Issue) {
    this.modalService.open(deleteModal).result.then(
      (result) => {
        if(result === 'delete') {
          this.issuesService.delete(issue)
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
