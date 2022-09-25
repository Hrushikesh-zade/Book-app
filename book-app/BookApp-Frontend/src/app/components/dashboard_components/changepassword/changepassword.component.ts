import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css'],
})
export class ChangepasswordComponent implements OnInit {
  changeCredentials: any = {
    password: '',
    repeatpassword: '',
  };

  constructor(private loginService: LoginService) {}

  ngOnInit(): void {}

  changePassword() {
    if (
      this.changeCredentials.password == null ||
      this.changeCredentials.repeatpassword == null ||
      this.changeCredentials.password == undefined ||
      this.changeCredentials.repeatpassword == undefined ||
      this.changeCredentials.password == '' ||
      this.changeCredentials.repeatpassword == ''
    ) {
      console.log(this.changeCredentials);
      alert('please fill some value');
    } else {
      if (
        this.changeCredentials.password != this.changeCredentials.repeatpassword
      ) {
        console.log(this.changeCredentials);
        alert('passwords does not match');
      } else {
        // this.changePasswordService.updatedata(this.changeCredentials);
        console.log('Inside...');
        console.log(this.changeCredentials.password);

        // ............
        var updated = {};
        var myJsonString = JSON.stringify(updated);
        var myJsonObject = JSON.parse(myJsonString);
        myJsonObject.email = localStorage.getItem('email');
        myJsonObject.password = this.changeCredentials.password;

        console.log(myJsonObject);

        this.loginService.changeThePassword(myJsonObject).subscribe(
          (res) => {
            console.log('password changed');
            alert("Password Changed successfully")
          },
          (err) => {
            console.log(err);
          }
        );
      }
    }
  }
}
