import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  credentials: any = {
    email: '',
    password: '',
  };

  constructor(
    private loginService: LoginService,
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    if (
      this.credentials.email === null ||
      this.credentials.password === null ||
      this.credentials.email === undefined ||
      this.credentials.password === undefined ||
      this.credentials.email === '' ||
      this.credentials.password === ''
    ) {
      console.log('Invalid input');
    } else {
      console.log('we have to submit the data');
      //token  generate
      this.loginService.generateToken(this.credentials).subscribe(
        (response: any) => {
          //if success
          console.log(response.token);

          // this._interactionService.variable1 = this.credentials.email;

          // console.log(this._interactionService.variable1);

          this.loginService.loginUser(response.token);

          // this.sendMessage(this.credentials.email);
          window.location.href = '/dashboard';
        },
        (error) => {
          console.log('something error occured');
          alert('PLease Enter the Valid credentials');

          console.log(error);
        }
      );
    }
  }
}
