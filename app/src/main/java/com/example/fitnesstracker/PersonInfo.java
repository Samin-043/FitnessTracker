package com.example.fitnesstracker;

public class PersonInfo {
    private  String gender;
    private  String name;
    private  String height;
    private  String weight;

    public PersonInfo(String person_name, String person_weight, String gender, String height) {
        this.name=person_name;
        this.gender=gender;
        this.height=height;
        this.weight=person_weight;
    }

    public PersonInfo() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}


