package com.example.demostudentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="module")
public class Module {

    @Id
    @Column(name="module_id")
    private int mid;

    @Column(name="module_name")
    private String mname;

    public Module() {
    }

    public Module(int mid, String mname) {
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
        return "Module{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                '}';
    }
}
