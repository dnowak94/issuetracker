import { Component, Input, OnInit, Optional } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Task, TaskStatus, TasksService } from '../../api';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './task-form.component.html',
  styleUrl: './task-form.component.scss'
})
export class TaskFormComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder,
    private tasksService: TasksService
  ) { }

  id: number | undefined;
  @Input() projectId?: number;
  task: Task | undefined;
  eTaskStatus = TaskStatus;

  taskForm = this.formBuilder.group({
    title: new FormControl('', {nonNullable: true}),
    description: new FormControl('', { nonNullable: true }),
    status: new FormControl<TaskStatus>(TaskStatus.Todo, {nonNullable: true})
  });

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      const taskId = Number(id);
      this.id = taskId;
      this.tasksService.getTask(this.projectId!, taskId, "body")
        .subscribe(task => {
          console.log("Get task(): ", JSON.stringify(task));
          this.taskForm.patchValue(task);
          this.task = task;
        });
    }
  }

  get f() { return this.taskForm.controls; }


  private saveTask() {
    return this.id === undefined
      ? this.tasksService.createTask(this.projectId!, this.taskForm.value, "body")
      : this.tasksService.updateTask(this.projectId!, this.id!, this.taskForm.value, "body");
  }

  onSubmit() {
    if (this.taskForm.valid) {
      this.saveTask()
        .subscribe({
          next: () => {
            console.log('task saved: ', JSON.stringify(this.taskForm.value));
            const urlSegments = this.router.parseUrl(this.router.url).root.children['primary'].segments;
            // go back to project
            const url = urlSegments.slice(0, -3);
            this.router.navigate(url.map((segment) => segment.path));
          },
          error: error => {
            console.log('task save error: ', error);
          }
        });
    }
  }
}
