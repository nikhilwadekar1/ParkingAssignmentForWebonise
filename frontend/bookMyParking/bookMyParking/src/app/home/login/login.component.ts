import { UserDetails } from './../../classes/user-details';
import { UserDetailsService } from './../../services/user-details.service';
import { DataService } from './../../services/data.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userForm: FormGroup;
  errorMessage = '';
  errorMessageClass = '';
  errorMessageFlag = false;
  constructor(
    private formBuilder: FormBuilder,
    private service: DataService,
    private userDetailsService: UserDetailsService,
    private router: Router
  ) { }

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  get userName() {
    return this.userForm.get('userName');
  }

  get password() {
    return this.userForm.get('password');
  }
  login() {
    this.service.login(this.userForm.value).subscribe(data => {
      if (data['loggedIn']) {
        const user = new UserDetails(data['userId'], data['city'], data['contactNo'], data['email'], data['password'], data['userName'],data['walletBalance'], data['loggedIn']);
        console.log(user);
        this.userDetailsService.userDatails = user;
        this.router.navigate(['homepage']);
      } else {
        this.errorMessage = data['userName'];
        this.errorMessageFlag = true;
        setTimeout(() => {
          this.errorMessageFlag = false;
        }, 3000);
      }
    })
  }

}
