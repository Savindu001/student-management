import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrl: './module.component.css'
})
export class ModuleComponent {
  isResultLoaded: any;
  ModuleArray : any[] = [];
  showForm = false;
  mid:any;
  mname: any;
  isSave: any;



  constructor(private http: HttpClient )
  {
    this.getAllModule();

  }

  openForm(data=null, isUpdate: string) {
    this.showForm=true;
    this.isSave = isUpdate;
    if(data)
    {
      // @ts-ignore
      this.mid=data.mid;
      // @ts-ignore
      this.mname=data.mname;
    }
    else
    {
      this.mid =null;
    }
  }

  setDelete(mid: any) {



      this.http.delete("http://localhost:8080/api/v1/module/delete-module"+"/"+mid,{responseType: 'text'}).subscribe((resultData: any)=>
      {
        console.log(resultData);
        this.getAllModule();
        this.mname = '';


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
    this.mid=null;
    this.mname=null;
  }

  private getAllModule() {

    this.http.get("http://localhost:8080/api/v1/module/get-all-modules")

      .subscribe((resultData: any)=>
      {
        this.showForm = false;
        console.log(resultData);
        this.ModuleArray = resultData;
      });

  }

  register()
  {

    let bodyData = {
      "mid" : this.mid,
      "mname" : this.mname,

    };

    this.http.post("http://localhost:8080/api/v1/module/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);

      this.getAllModule();
      this.mid = '';
      this.mname = '';
    });
  }


  UpdateRecords()
  {
    let bodyData = {
      "mid" : this.mid,
      "mname" : this.mname,

    };

    this.http.put("http://localhost:8080/api/v1/module/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);

      this.getAllModule();
      this.mname = '';
    });
  }
}
