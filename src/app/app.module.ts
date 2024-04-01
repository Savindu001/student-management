import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import { LectureComponent } from './lecture/lecture.component';
import { CourseComponent } from './course/course.component';
import { ModuleComponent } from './module/module.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientJsonpModule, HttpClientModule, HttpClientXsrfModule} from "@angular/common/http";
import {ServiceService} from "./service.service";


// @ts-ignore
// @ts-ignore
// @ts-ignore
// @ts-ignore
// @ts-ignore
// @ts-ignore
// @ts-ignore
// @ts-ignore
// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StudentComponent,
    LectureComponent,
    CourseComponent,
    ModuleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    HttpClientJsonpModule,
    HttpClientModule,
  ],
  providers: [
    provideClientHydration()

  ],

  bootstrap: [AppComponent]
})
export class AppModule { }


