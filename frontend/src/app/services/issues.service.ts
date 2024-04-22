import { Injectable } from '@angular/core';
import { Issue } from '../model/Issue';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IssuesService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getIssues(): Observable<Issue[]> {
    return this.http.get<Issue[]>(environment.ISSUES_URL)
      .pipe(
        tap(_ => console.log("fetched issues"))
      );
  }
  getIssue(id: number): Observable<Issue> {
    return this.http.get<Issue>(`${environment.ISSUES_URL}/${id}`)
      .pipe(
        tap(_ => console.log("fetched issue with id=", id))
      );
  }
  
  createIssue(issue:Issue): Observable<any> {
    return this.http.post(`${environment.ISSUES_URL}`, issue, this.httpOptions)
      .pipe(
        tap(issue => console.log("issue created: ", JSON.stringify(issue)))
      );
  }

  updateIssue(issue: Issue): Observable<any> {
    return this.http.put(`${environment.ISSUES_URL}/${issue.id}`, issue, this.httpOptions)
      .pipe(
        tap(_ => console.log("save issue:", JSON.stringify(issue)))
      );
  }

  delete(issue:Issue):Observable<any> {
    return this.http.delete(`${environment.ISSUES_URL}/${issue.id}`);
  }
}
