import { Component } from '@angular/core';
import { ProjectsListComponent } from '../../projects/projects-list/projects-list.component';
@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [ProjectsListComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

}
