import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Task, TaskStatus } from '../../../api/generated/projects';
import { SharedModule } from '../../../shared/shared.module';
import { Observable, map } from 'rxjs';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, SharedModule],
  templateUrl: './task-form.component.html',
  styleUrl: './task-form.component.scss'
})
export class TaskFormComponent implements OnInit {
  @Input() task$: Observable<Task>;
  @Output() taskSubmit = new EventEmitter();
  taskForm$: Observable<FormGroup>;
  eTaskStatus = TaskStatus;

  constructor(private formBuilder:FormBuilder) {
    this.task$ = new Observable<Task>();
    this.taskForm$ = new Observable<FormGroup>();
  }

  ngOnInit(): void {
    this.taskForm$ = this.task$.pipe(
        map(task => {
          const { title, description, status, createdAt, updatedAt } = task;
          return this.formBuilder.group({
            id: task.id,
            title: new FormControl(title, [
              Validators.required
            ]),
            description: new FormControl(description, [
              Validators.required
            ]),
            status: new FormControl<TaskStatus>(status!, [
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
    this.taskSubmit.emit(form.value);
  }
}
