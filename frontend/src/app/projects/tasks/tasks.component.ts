import { Component, Input, OnInit, TemplateRef, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { bootstrapJournalPlus, bootstrapPencil, bootstrapTrash } from '@ng-icons/bootstrap-icons';
import { Task, TasksService } from '../../api/generated/projects';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css',
  standalone: true,
  imports: [
    CommonModule, NgIconComponent, RouterLink
  ],
  providers: [provideIcons({bootstrapTrash, bootstrapPencil, bootstrapJournalPlus})]
})
export class TasksComponent implements OnInit {
  
  @Input() projectId?:number;
  tasks:Task[] = [];
  private modalService = inject(NgbModal);

  constructor(private tasksService: TasksService) {}
  ngOnInit(): void {
    this.getTasks();
  }
  getTasks():void {
    this.tasksService.getTasks(this.projectId!)
    .subscribe(tasks => this.tasks = tasks);
  }

  getDeleteModalTitle(task:Task) {
    return `delete task '${task.title}'`;
  }

  getDeleteModalMessage(task:Task) {
    return `Are you sure you want to delete task '${task.title}'`;
  }

  onDeleteClick(deleteModal: TemplateRef<any>, task:Task) {
    this.modalService.open(deleteModal).result.then(
      (result) => {
        if(result === 'delete') {
          this.tasksService.deleteTask(this.projectId!, task.id!, "body", false)
          .subscribe(
            _ => {
              console.log(`task with id=${task.id} deleted.`);
              this.getTasks();
            }
          );
        }
      }
    )
  }
}
