package com.example.busticket;

public class adminaddnearandbuses {


    int id;

    public adminaddnearandbuses(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String bus,cate,area;





    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public adminaddnearandbuses(int id, String bus, String cate, String area) {
        this.id = id;
        this.bus = bus;
        this.cate = cate;
        this.area = area;


    }
}
