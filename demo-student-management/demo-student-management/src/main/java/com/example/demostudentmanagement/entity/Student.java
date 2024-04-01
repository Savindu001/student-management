package com.example.demostudentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="student")
public class Student {
   @Id
   @Column(name="Student_id")
    private int sid;

    @Column(name="Student_name")

   private String Sname;
    @Column(name="Student_address")
   private String address;

    public Student(int sid, String sname, String address) {
        this.sid = sid;
        Sname = sname;
        this.address = address;
    }

    public Student() {

    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return Sname;
    }

    public String getAddress() {
        return address;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", Sname='" + Sname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
