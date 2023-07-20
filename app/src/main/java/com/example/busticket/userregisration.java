package com.example.busticket;

public class userregisration {

    int id;
    String name,cnic,phone,pswd,cpswd,address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getCpswd() {
        return cpswd;
    }

    public void setCpswd(String cpswd) {
        this.cpswd = cpswd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public userregisration(int id, String name, String cnic, String phone, String pswd, String cpswd, String address) {
        this.id = id;
        this.name = name;
        this.cnic = cnic;
        this.phone = phone;
        this.pswd = pswd;
        this.cpswd = cpswd;
        this.address = address;
    }
}
