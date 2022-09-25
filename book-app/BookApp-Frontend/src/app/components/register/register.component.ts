import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  //declaring required variables
  registerFormGroup!: FormGroup;
  message: string = '';
  users: User[] = [];
  registerCredentials = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    phoneNumber: '',
  };

  //method to execute on submitting form
  onSubmit(onSubmit: any) {
    this.postNewUser();
    // this.router.navigate(['/login']);
  }

  constructor(
    private cont: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {}

  //create new form group onInit
  ngOnInit(): void {
    this.registerFormGroup = this.cont.group({
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      email: ['', [Validators.required]],
      password: ['', [Validators.required]],
      phoneNumber: ['', [Validators.required]],
    });
  }

  // Post new contact to json server by making POST request
  postNewUser() {
    this.userService.addUser(this.registerCredentials).subscribe(
      (response: any) => {
        console.log('sending the user registration data...');
        alert("You have successfully registered.")
        window.location.href = '/login';
      },
      (error) => {console.log(error);
        alert("Some Error occured. Try registering with different mail.")
      }
    );

    this.message = 'user added';

    // post Api
  }
}
