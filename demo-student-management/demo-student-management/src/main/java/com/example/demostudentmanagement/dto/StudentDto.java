package com.example.demostudentmanagement.dto;

import jakarta.persistence.Column;
import org.antlr.v4.runtime.misc.NotNull;

public class StudentDto {


    private int sid;
    private String Sname;

    private String address;

    public StudentDto() {
    }

    public StudentDto(int sid, String sname, String address) {
        this.sid = sid;
        Sname = sname;
        this.address = address;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "sid=" + sid +
                ", Sname='" + Sname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
