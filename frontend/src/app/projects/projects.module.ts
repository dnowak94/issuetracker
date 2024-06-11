import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterLink } from '@angular/router';
import { bootstrapJournalPlus, bootstrapPencil, bootstrapTrash } from '@ng-icons/bootstrap-icons';
import { NgIconComponent, NgIconsModule } from '@ng-icons/core';
import { SharedModule } from '../shared/shared.module';
import { EnumToArrayPipe } from './enum-to-array.pipe';
import { NotFoundComponent } from './not-found/not-found.component';
import { ProjectsRoutingModule } from './projects-routing.module';

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
