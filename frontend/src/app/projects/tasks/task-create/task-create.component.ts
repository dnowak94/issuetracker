import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, switchMap } from 'rxjs';
import { Task, TaskStatus, TasksService } from '../../../api/generated/projects';
import { TaskFormComponent } from '../task-form/task-form.component';

@Component({
  selector: 'app-task-create',
  templateUrl: './task-create.component.html',
  styleUrl: './task-create.component.css',
  standalone: true,
  imports: [CommonModule, TaskFormComponent]
})
export class TaskCreateComponent implements OnInit {
  task$:Observable<Task>;
  projectId?:number;

  constructor(private tasksService:TasksService, private route:ActivatedRoute) {
    this.task$ = new Observable<Task>((subscriber) => {
      subscriber.next(
        {
          title: '',
          description: '',
          status: TaskStatus.Todo
        }
      );
    });
  }

  ngOnInit(): void {
      this.projectId = Number(this.route.snapshot.paramMap.get('projectId'));
  }

  onSubmit(task:Task) {
    this.route.paramMap.pipe(
      switchMap(params => {
        const projectId = Number(params.get('projectId'));
        return this.tasksService.createTask(projectId, task);
      })
    )
    .subscribe(response => console.log(response));
  }
}
