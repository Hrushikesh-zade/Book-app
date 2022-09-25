import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { catchError, Observable, throwError, retry } from 'rxjs';
import { Book } from '../models/Book';

const URL = 'http://localhost:8000/api/v1';
// const httpOptions = {
//   headers: new HttpHeaders({
//     'content-type': 'application/json'
//   })
// }
@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private http: HttpClient) {}

  //Implement getAllBooks method using HttpClient for getting all Books details GET request
  getAllBooks() {
    return this.http.get(`${URL}/books`);
  }
  
  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      //client side error
      console.error('An error occured', error.error);
    } else {
      //server side error or backend error
      console.error(
        `Backend returned code ${error.status}, body was:`,
        error.error
      );
    }
    return throwError(
      () =>
        new Error('Something bad happened; please try again after some time.')
    );
  }
}
