import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-lecture',
  templateUrl: './lecture.component.html',
  styleUrl: './lecture.component.css'
})
export class LectureComponent {

  LectureArray : any[] = [];
  showForm = false;
  lid:any;
  lname: any;
  laddress:any;
  isResultLoaded: any;
  isSave: any;

  constructor(private http: HttpClient )
  {
    this.getAllLecture();
  }

  openForm(data=null, isUpdate: string) {
    this.showForm=true;
    this.isSave = isUpdate;
    if(data)
    {
      // @ts-ignore
      this.lid=data.lid;
      // @ts-ignore
      this.lname=data.lname;
      // @ts-ignore
      this.laddress=data.laddress;
    }
    else
    {
      this.lid =null;
    }
  }

  setDelete(lid: any) {

    this.http.delete("http://localhost:8080/api/v1/lecture/delete-lecture"+"/"+lid,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
      this.getAllLecture();
      this.lname = '';
      this.laddress='';


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

  private getAllLecture() {

    this.http.get("http://localhost:8080/api/v1/lecture/get-all-lectures")

      .subscribe((resultData: any)=>
      {
        this.showForm = false;
        console.log(resultData);
        this.LectureArray = resultData;
      });
  }

  private clearForm() {
    this.lid=null;
    this.lname=null;
    this.laddress=null;
  }

  register()
  {

    let bodyData = {
      "lid" : this.lid,
      "lname" : this.lname,
      "laddress":this.laddress

    };

    this.http.post("http://localhost:8080/api/v1/lecture/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
      this.getAllLecture();
      this.lid = '';
      this.lname = '';
      this.laddress='';
    });
  }


  UpdateRecords()
  {
    let bodyData = {
      "lid" : this.lid,
      "lname" : this.lname,
      "laddress":this.laddress

    };

    this.http.put("http://localhost:8080/api/v1/lecture/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
      this.getAllLecture();
      this.lname = '';
      this.laddress='';
    });
  }

}
