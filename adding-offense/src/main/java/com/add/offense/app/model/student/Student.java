package com.add.offense.app.model.student;

public class Student {
    private String studentId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String sex;
    private String address;
    private String contactNumber;

    public Student() {
    }

    // Getters and Setters
    public String getStudentId() {

        return studentId;
    }

    public void setStudentId(String studentId) {

        this.studentId = studentId;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getMiddleName() {

        return middleName;
    }

    public void setMiddleName(String middleName) {

        this.middleName = middleName;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {

        this.sex = sex;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getContactNumber() {

        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {

        this.contactNumber = contactNumber;
    }

    public String getStudentName() {
        return null;
    }

    public int getStudentAge() {

        return 0;
    }

    public String getStudentAddress() {
        return null;
    }


}
