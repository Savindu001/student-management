import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ServiceService} from "../service.service";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrl: './course.component.css'
})
export class CourseComponent  {

  CourseArray : any[] = [];
  showForm = false;
  cid:any;
  cname: any;
  isResultLoaded: any;
  isSave: any;

  constructor(private http: HttpClient )
  {
    this.getAllCourse();
  }

  openForm(data=null, isUpdate: string) {
   this.showForm=true;
   this.isSave = isUpdate;
   if(data)
   {
     // @ts-ignore
     this.cid=data.cid;
     // @ts-ignore
     this.cname=data.cname;
   }
   else
   {
     this.cid =null;
   }
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

  closeForm()
  {
    this.showForm=false;
    this.clearForm();
  }

  clearForm()
  {
    this.cid=null;
    this.cname=null;
  }

  private getAllCourse() {

    this.http.get("http://localhost:8080/api/v1/course/get-all-courses")

      .subscribe((resultData: any)=>
      {
        this.showForm = false;
        console.log(resultData);
        this.CourseArray = resultData;
      });

  }

  register()
  {

    let bodyData = {
      "cid" : this.cid,
      "cname" : this.cname,

    };

    this.http.post("http://localhost:8080/api/v1/course/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
      this.getAllCourse();
      this.cid = '';
      this.cname = '';
    });
  }




  UpdateRecords()
  {
    let bodyData = {
      "cid" : this.cid,
      "cname" : this.cname,

    };

    this.http.put("http://localhost:8080/api/v1/course/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
      this.getAllCourse();
      this.cname = '';
    });
  }

  setDelete(cid: any)
  {
     this.http.delete("http://localhost:8080/api/v1/course/delete-course"+"/"+cid,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
      this.getAllCourse();
      this.cname = '';
    });
  }






}
