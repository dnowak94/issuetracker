import { Component } from '@angular/core';
import { ProjectsListComponent } from '../projects-list/projects-list.component';

@Component({
    selector: 'app-projects-home',
    standalone: true,
    templateUrl: './projects-home.component.html',
    styleUrl: './projects-home.component.scss',
    imports: [ProjectsListComponent]
})
export class ProjectsHomeComponent {
    
}
