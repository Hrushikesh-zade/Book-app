import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { User } from '../models/User';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class UserService {
  URL = 'http://localhost:8300/api/v1/users';

  constructor(private http: HttpClient) {}

  // Implement addUser method using HttpClient for saving a Users details by making POST request
  addUser(registerCredentials: any) {
    console.log("in adduser method");
    return this.http
      .post(`${this.URL}`, registerCredentials)
      // .pipe(retry(1), catchError(this.handleError));
  }

  // Implement getAllUsers method using HttpClient for getting all Users details GET request
  getAllUsers(): Observable<any> {
    return this.http
      .get<User[]>(this.URL)
      .pipe(retry(1), catchError(this.handleError));
  }

  // handle error function
  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `,
        error.error
      );
    }
    // Return an observable with a user-facing error message.
    return throwError(
      () => new Error('Something bad happened; please try again later.')
    );
  }
}
