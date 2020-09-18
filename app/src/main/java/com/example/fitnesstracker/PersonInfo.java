package com.example.fitnesstracker;

public class PersonInfo {
    private  String gender;
    private  String name;
    private  String height;
    private  String weight;


    public PersonInfo()
    {

    }

    public PersonInfo(String name, String weight, String gender, String height) {

        this.gender = gender;
        this.name = name;
        this.height = height;
        this.weight = weight;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}


