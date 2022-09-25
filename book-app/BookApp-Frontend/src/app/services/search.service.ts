import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  url = "http://localhost:8080/api/v1/apibooks/"
  url2 = "http://localhost:8080/api/v1/apibooks/Author/"

  newurl = "";

  constructor(private http : HttpClient) { }

  getDataByTitle(query : any){
    this.newurl =  this.url + query;
    return this.http.get(this.newurl)

  }
  getDataByAuthor(query : any){
    this.newurl =  this.url + query;
    return this.http.get(this.newurl)

  }
}
