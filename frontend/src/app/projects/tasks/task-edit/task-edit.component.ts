import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Task, TasksService } from '../../../api/generated/projects';
import { TaskFormComponent } from '../task-form/task-form.component';
import { Observable, switchMap } from 'rxjs';

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrl: './task-edit.component.css',
  standalone: true,
  imports: [CommonModule, TaskFormComponent]
})
export class TaskEditComponent implements OnInit {
  task$: Observable<Task>;
  projectId?:number;
  constructor(private route:ActivatedRoute, private tasksService:TasksService) {
    this.task$ = this.route.paramMap.pipe(
      switchMap((params) => {
        this.projectId = Number(params.get('projectId'));
        const taskId = Number(params.get('taskId'));
        return this.tasksService.getTask(this.projectId, taskId);
      })
    );
  }

  ngOnInit(): void {
    
  }

  onSubmit(task:Task) {
    this.tasksService.updateTask(this.projectId!, task.id!, task)
    .subscribe((response) => {
      console.log(response);
    });
  }
}
