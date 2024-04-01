package com.example.demostudentmanagement.dto;

import jakarta.persistence.Column;

public class CourseDto {

    private int cid;
    private String cname;

    public CourseDto() {
    }

    public CourseDto(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
