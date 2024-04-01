package com.example.demostudentmanagement.dto.request;

public class ModuleUpdateDTo {

    private int mid;
    private String mname;

    public ModuleUpdateDTo() {
    }

    public ModuleUpdateDTo(int mid, String mname) {
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
        return "ModuleUpdateDTo{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                '}';
    }
}
