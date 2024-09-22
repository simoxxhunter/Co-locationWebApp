
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onLogin() {
    this.authService.login(this.email, this.password).subscribe(
      (response) => {
        const token = response.token;
        const role = response.role;

        if (token && role) {
          localStorage.setItem('authToken', token);
          localStorage.setItem('role', role);

          if (role === 'ADMIN') {
            this.router.navigate(['/admin']);
          } else if (role === 'USER') {
            this.router.navigate(['/index']);
          } else {
            alert('Role not recognized');
          }
        } else {
          alert('Invalid login response');
        }
      },
      (error) => {
        alert('Login failed');
      }
    );
  }
}

