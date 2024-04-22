import { Injectable } from '@angular/core';
import { Issue } from '../model/Issue';
import { Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IssuesMockService {
  issues: Issue[] = [
    new Issue("Test1",""),
    new Issue("Test2","")
  ]
  getIssues():Observable<Issue[]> {
    return of(this.issues);
  }
}
