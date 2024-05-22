import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent {
  username: string = "";
  password: string = "";
  errorMessage: string = "";
  userId:number = 0;

  constructor(private http: HttpClient, private router: Router) {}

  login(): void {
    this.http.post<{ success: boolean, userId: number }>('http://localhost:8080/login', { username: this.username, password: this.password })
      .subscribe(response => {
        if (response.success) {
          if (response.userId) {
            this.router.navigate(['/user-profile', response.userId]);
          } else {
            this.errorMessage = 'User profile not found';
          }
        } else {
          this.errorMessage = 'Error';
        }
      });
  }
  
}
