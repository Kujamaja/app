import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.scss']
})
export class CourseListComponent implements OnInit {
  courses: any[] | undefined;
  youtubeLink: SafeResourceUrl | undefined;

  constructor(private http: HttpClient,private sanitizer: DomSanitizer,private router: Router) {
    this.youtubeLink = this.sanitizer.bypassSecurityTrustResourceUrl("https://www.youtube.com/embed/6G19kFcVXTo");
  }

  navigateToCourse(courseId: number) {
    this.router.navigate(['/courses', courseId]);
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
