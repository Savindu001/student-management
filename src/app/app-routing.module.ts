import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {StudentComponent} from "./student/student.component";
import {LectureComponent} from "./lecture/lecture.component";
import {CourseComponent} from "./course/course.component";
import {ModuleComponent} from "./module/module.component";




const routes: Routes = [

  {path:'',component:HomeComponent},
  {path:'student',component:StudentComponent},
  {path:'lecture',component:LectureComponent},
  {path:'course',component:CourseComponent},
  {path:'module',component:ModuleComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
