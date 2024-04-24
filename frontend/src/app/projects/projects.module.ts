import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectsRoutingModule } from './projects-routing.module';
import { EnumToArrayPipe } from './enum-to-array.pipe';
import { TasksComponent } from './tasks/tasks.component';
import { NgIconComponent, NgIconsModule, provideIcons } from '@ng-icons/core';
import { bootstrapJournalPlus, bootstrapPencil, bootstrapTrash } from '@ng-icons/bootstrap-icons';
import { RouterLink } from '@angular/router';
import { IssuesComponent } from './issues/issues.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    EnumToArrayPipe
  ],
  imports: [
    CommonModule,
    ProjectsRoutingModule,
    NgIconComponent,
    RouterLink,
    NgIconComponent,
    NgIconsModule.withIcons({bootstrapJournalPlus, bootstrapPencil, bootstrapTrash })
  ]
})
export class ProjectsModule { }
