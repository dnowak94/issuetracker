import { Injectable } from '@angular/core';
import { Issue } from '../model/Issue';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IssuesService {  
  
  constructor(private http:HttpClient) {}
  
  getIssues():Observable<Issue[]> {
    console.log(`url: ${environment.ISSUES_URL}`);
    return this.http.get<Issue[]>(environment.ISSUES_URL)
      .pipe(
        tap(_ => console.log("fetched issues"))
      );
  }
}
