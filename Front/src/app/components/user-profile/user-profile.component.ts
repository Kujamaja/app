import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  userId: number | undefined;
  user: any; 

  constructor(private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.userId = params['userId'];
      if (this.userId) {
        this.getUserProfile(this.userId);
      }
    });
  }

  getUserProfile(userId: number): void {
    this.http.get<any>(`http://localhost:8080/users/user/${userId}`)
      .subscribe(user => {
        this.user = user;
      }, error => {
        console.error('Error fetching user profile:', error);
      });
  }
}
