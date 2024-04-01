package com.example.demostudentmanagement.dto.request;

public class LectureUpdateDTo {

    private int lid;
    private String lname;
    private String laddress;

    public LectureUpdateDTo() {
    }

    public LectureUpdateDTo(int lid, String lname, String laddress) {
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
        return "LectureUpdateDTo{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", laddress='" + laddress + '\'' +
                '}';
    }
}
