package com.example.busticket;

public class filteradapter {

    String area,cate,bus;

    public filteradapter(String area, String cate, String bus) {
        this.area = area;
        this.cate = cate;
        this.bus = bus;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }
}
