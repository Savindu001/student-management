package com.example.demostudentmanagement.dto;

import jakarta.persistence.Column;

public class ModuleDto {

    private int mid;
    private String mname;

    public ModuleDto() {
    }

    public ModuleDto(int mid, String mname) {
        this.mid = mid;
        this.mname = mname;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "ModuleDto{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                '}';
    }
}

