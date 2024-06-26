import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CoursePageComponent } from './components/course-page/course-page.component';
import { CourseListComponent } from './components/course-list/course-list.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';




@NgModule({
  declarations: [
    AppComponent,
    CoursePageComponent,
    CourseListComponent,
    LoginPageComponent,
    UserProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
