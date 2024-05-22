import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-course-page',
  templateUrl: './course-page.component.html',
  styleUrls: ['./course-page.component.scss']
})
export class CoursePageComponent implements OnInit {
  courseId: number | undefined;
  videoUrl!: SafeResourceUrl;
  courseName: string | undefined;

  constructor(
    private http: HttpClient,
    private sanitizer: DomSanitizer,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const courseId = params.get('id');
      if (courseId) {
        this.courseId = +courseId;
        this.getCourseData(this.courseId);
      }
    });
  }

  getCourseData(courseId: number) {
    this.http.get<any>(`http://localhost:8080/courses/${courseId}`)
      .subscribe(course => {
        this.courseName = course.name;
        this.videoUrl = this.sanitizer.bypassSecurityTrustResourceUrl(course.video);
      });
  }
}
