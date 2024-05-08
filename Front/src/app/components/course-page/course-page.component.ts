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
    this.route.params.subscribe(params => {
      this.courseId = params['id'];
      // Tutaj możesz wykonać zapytanie HTTP, aby pobrać dane kursu na podstawie ID
      // Przykładowo:
      this.http.get<any>('http://localhost:8080/courses/' + this.courseId).subscribe(
        (data: any) => {
          console.log(data);
          this.courseName = data.name;
          this.videoUrl = this.transform(data.videoUrl);}
  
      );
    });
  }

  transform(url: string): SafeResourceUrl {
    const videoId = url.split('v=')[1];
    const embedUrl = `https://www.youtube.com/embed/${videoId}`;
    return this.sanitizer.bypassSecurityTrustResourceUrl(embedUrl);
  }
}
