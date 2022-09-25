import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url = 'http://localhost:8300/api/v1/users'

  // public emailNeeded  = "" ;

  newUrl = '';

  constructor(private http: HttpClient) { }

  //calling the server to generate the token
  generateToken(credentials : any){
    //token generate
    // this.emailNeeded = credentials.email;
    localStorage.setItem("email",credentials.email);
    return this.http.post(`${this.url}/login`,credentials)
  }



  loginUser(token : any){
    localStorage.setItem("token",token);
    return true;
  }

  //to check that user is logged in or not
  isLoggedIn(){
    let token = localStorage.getItem("token");
  if(token==undefined || token === '' || token == null){
    return false;
  }
  else{
    return true;
  }
  }

  // to logout the user
  logout(){
    localStorage.removeItem('token');
    return true;
  }

  //for getting the token
  getToken(){
    return localStorage.getItem("token")
  }

  createUrlForPasswordChange(){
this.newUrl = this.url + "/"+ localStorage.getItem("email");
  }


  changeThePassword(s : any){
    this.createUrlForPasswordChange();
return this.http.put(this.newUrl,s);
  }
  

}
