package com.phonenumbers.model;
//POJO User class. Represents user in a company
public class User {
    private Integer company;
    private String name;
    private String phone;

    public User (String name, int company, String phone){
        this.name=name;
        this.company=company;
        this.phone=phone;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
