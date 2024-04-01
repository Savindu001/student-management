import {Component, NgIterable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import * as http from "http";
import {ServiceService} from "../service.service";

import {response} from "express";


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})
export class StudentComponent {

  StudentArray : any[] = [];
  showForm = false;
  sid:any;
  sname: any;
  address:any;
  isResultLoaded: any;
  isSave: any;
  constructor(private http: HttpClient )
  {
    this.getAllStudent();
  }

  openForm(data=null, isUpdate: string) {
    this.showForm=true;
    this.isSave = isUpdate;
    if(data)
    {
      // @ts-ignore
      this.sid=data.sid;
      // @ts-ignore
      this.sname=data.sname;
      // @ts-ignore
      this.address=data.address;

    }
    else
    {
      this.sid =null;
    }

  }

  setDelete(sid: any) {

    this.http.delete("http://localhost:8080/api/v1/student/delete-student"+"/"+sid,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
      this.getAllStudent();
      this.sname = '';
      this.address='';


    });

  }

  saveCourse() {
    if(this.isSave === 'S')
    {
      this.register();
    }
    else
    {
      this.UpdateRecords();
    }
  }

  closeForm() {
    this.showForm=false;
    this.clearForm();

  }

  private clearForm() {
    this.sid=null;
    this.sname=null;
    this.address=null;
  }

  private getAllStudent() {
    this.http.get("http://localhost:8080/api/v1/student/get-all-students")

      .subscribe((resultData: any)=>
      {
        this.showForm = false;
        console.log(resultData);
        this.StudentArray = resultData;
      });

  }

  register()
  {

    let bodyData = {
      "sid" : this.sid,
      "sname" : this.sname,
      "address":this.address

    };

    this.http.post("http://localhost:8080/api/v1/student/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
      this.getAllStudent();
      this.sid = '';
      this.sname = '';
      this.address='';
    });
  }

  UpdateRecords()
  {
    let bodyData = {
      "sid" : this.sid,
      "sname" : this.sname,
      "address":this.address

    };

    this.http.put("http://localhost:8080/api/v1/student/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
      this.getAllStudent();
      this.sname = '';
      this.address='';
    });
  }
}


