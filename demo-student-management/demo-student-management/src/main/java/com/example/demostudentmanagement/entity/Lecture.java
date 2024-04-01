package com.example.demostudentmanagement.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="lecture")
public class Lecture {

    @Id
    @Column(name="lecture_id")
    private int lid;

    @Column(name="lecture_name")
    private String lname;
    @Column(name="lecture_address")
    private String laddress;

    public Lecture() {
    }

    public Lecture(int lid, String lname, String laddress) {
        this.lid = lid;
        this.lname = lname;
        this.laddress = laddress;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLaddress() {
        return laddress;
    }

    public void setLaddress(String laddress) {
        this.laddress = laddress;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", laddress='" + laddress + '\'' +
                '}';
    }
}
