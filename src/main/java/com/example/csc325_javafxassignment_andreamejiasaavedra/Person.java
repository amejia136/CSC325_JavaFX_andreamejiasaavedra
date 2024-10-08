package com.example.csc325_javafxassignment_andreamejiasaavedra;

public class Person {
    private int ID;
    private String firstName;
    private String lastName;
    private String departmentName;
    private String majorName;
    private String emailName;

    public Person() {
        this.ID = 0;
        this.firstName = "John";
        this.lastName = "Doe";
        this.departmentName = "N/A";
        this.majorName = "N/A";
        this.emailName = "N/A";
    }

    public Person(int ID, String firstName, String lastName, String departmentName, String majorName, String emailName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentName = departmentName;
        this.majorName = majorName;
        this.emailName = emailName;
    }

    public Person(Person p) {
        this.ID = p.ID;
        this.firstName = p.firstName;
        this.lastName = p.lastName;
        this.departmentName = p.departmentName;
        this.majorName = p.majorName;
        this.emailName = p.emailName;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMajorName() {
        return this.majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }
}
