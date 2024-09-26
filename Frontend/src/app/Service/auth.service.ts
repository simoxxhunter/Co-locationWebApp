import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8089/api/v1/auth';

  role = 'USER';
  
  constructor(private http: HttpClient, private router: Router) { }

  login(email: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/authenticate`, { email, password });
  }

  register(userData: { email: string, password: string, firstName: string, lastName: string, username: string, phoneNumber: string , role: string }): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/register`, userData);
  }
  

  saveToken(token: string): void {
    localStorage.setItem('authToken', token);
  }

  getToken(): string | null {
    return localStorage.getItem('authToken');
  }

  getRole(): string | null {
    return localStorage.getItem('role');
  }

  logout(): void {
    localStorage.removeItem('authToken');
    localStorage.removeItem('role');
    this.router.navigate(['/login']);
  }
}
