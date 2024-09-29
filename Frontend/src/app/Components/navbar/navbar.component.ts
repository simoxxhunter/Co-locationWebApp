import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/Service/Authentification/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{

  constructor(private AuthService: AuthService, private router: Router) {}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  logout(): void {
    this.AuthService.logout();
    this.router.navigate(['/login']);
  }
  title = 'ColocationAngular';
}
