import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Service/Authentification/auth.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})


export class SignupComponent implements OnInit{

  signupForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {}


  ngOnInit() {
    const script = document.createElement('script');
    script.src = 'assets/js/webflow.js';
    script.type = 'text/javascript';
    document.body.appendChild(script);

    this.signupForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]]})
  }

  onSubmit() {
    if (this.signupForm.valid) {
      const formData = {
        email: this.signupForm.value.email,
        password: this.signupForm.value.password,
        firstname: this.signupForm.value.firstName,
        lastname: this.signupForm.value.lastName,
        username: this.signupForm.value.username,
        phonenumber: this.signupForm.value.phoneNumber,
        role : 'USER'

      };
  
      this.authService.register(formData).subscribe(
        response => {
          this.authService.saveToken(response.token);
          this.router.navigate(['/dashboard']);
        },
        error => {
          console.error('Registration failed', error);
        }
      );
    }
  }
  
  
  

}
