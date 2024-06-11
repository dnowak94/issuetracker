import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectsRoutingModule } from './projects-routing.module';
import { EnumToArrayPipe } from './enum-to-array.pipe';
import { NgIconComponent, NgIconsModule } from '@ng-icons/core';
import { bootstrapJournalPlus, bootstrapPencil, bootstrapTrash } from '@ng-icons/bootstrap-icons';
import { RouterLink } from '@angular/router';
import { NotFoundComponent } from './not-found/not-found.component';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    EnumToArrayPipe,
    NotFoundComponent
  ],
  imports: [
    CommonModule,
    ProjectsRoutingModule,
    NgIconComponent,
    RouterLink,
    NgIconComponent,
    NgIconsModule.withIcons({bootstrapJournalPlus, bootstrapPencil, bootstrapTrash }),
    SharedModule
  ]
})
export class ProjectsModule { }
