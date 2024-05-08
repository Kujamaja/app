import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  courses: any[] | undefined;
  youtubeLink: SafeResourceUrl | undefined;

  constructor(private http: HttpClient,private sanitizer: DomSanitizer) {
    this.youtubeLink = this.sanitizer.bypassSecurityTrustResourceUrl("https://www.youtube.com/embed/6G19kFcVXTo");
  }

  ngOnInit() {
    this.getAllCourses();
  }

  getAllCourses() {
    this.http.get<any[]>('http://localhost:8080/courses')
      .subscribe(courses => {
        this.courses = courses;
      });
  }

  viewComments(courseId: number) {
    this.http.get<any[]>(`http://localhost:8080/courses/${courseId}/comments`)
      .subscribe(comments => {
        console.log(comments);
      });
  }
}
