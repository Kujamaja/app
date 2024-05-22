import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseListComponent } from './components/course-list/course-list.component';
import { CoursePageComponent } from './components/course-page/course-page.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { LoginPageComponent } from './components/login-page/login-page.component';

const routes: Routes = [
  { path: 'courses', component: CourseListComponent },
  { path: 'courses/:id', component: CoursePageComponent }, 
  {path: 'user-profile/:userId', component: UserProfileComponent },
  {path: 'login', component: LoginPageComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
