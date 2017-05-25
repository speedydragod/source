package com.model.FilterPattern;

/**
 * Created by Administrator on 2017/5/25.
 */
public class Person {

    private  String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String render, String maritalStatus) {
        this.name = name;
        this.gender = render;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
