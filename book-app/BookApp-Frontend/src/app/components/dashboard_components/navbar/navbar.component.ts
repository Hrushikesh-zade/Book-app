import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  searchvalue: any = {
    search: '',
    email: localStorage.getItem('email')
  };

  public loggedIn = false;

  constructor(private loginService:LoginService,private router: Router) { }

  ngOnInit(): void {
this.loggedIn = this.loginService.isLoggedIn();

  }

  logoutUser(){
    this.loginService.logout();
    location.reload();
    // location.href="/login";
  }

  Search(){
    console.log(this.searchvalue.search);
    console.log(typeof(this.searchvalue.search));
    let newSearch = this.searchvalue.search.replace(/ /g, "+");
    console.log(newSearch);
    localStorage.setItem("search",newSearch);
this.router.navigate(["/searched"]);
    
    
    
  }

}
