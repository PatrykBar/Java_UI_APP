package Patryk.sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {

    private int ID;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty academicTitle;
    private int academyID;
    private int departmentID;
    private SimpleIntegerProperty phoneNumber;
    private SimpleStringProperty emailAddress;
    private SimpleIntegerProperty numberOfDinners;
    private SimpleIntegerProperty numberOfNights;

    public Person() {
//        this.ID = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.surname = new SimpleStringProperty();
        this.academicTitle = new SimpleStringProperty();
//        this.departmentID = new SimpleIntegerProperty();
        this.phoneNumber = new SimpleIntegerProperty();
        this.emailAddress = new SimpleStringProperty();
        this.numberOfDinners = new SimpleIntegerProperty();
        this.numberOfNights = new SimpleIntegerProperty();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getAcademicTitle() {
        return academicTitle.get();
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle.set(academicTitle);
    }

    public int getDepartmentID() { return departmentID; }

    public void setDepartmentID(int departmentID) { this.departmentID = departmentID; }

    public int getAcademyID() { return academyID; }

    public void setAcademyID(int academyID) { this.academyID = academyID; }

    public int getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEmailAddress() {
        return emailAddress.get();
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }

    public int getNumberOfDinners() {
        return numberOfDinners.get();
    }

    public void setNumberOfDinners(int numberOfDinners) {
        this.numberOfDinners.set(numberOfDinners);
    }

    public int getNumberOfNights() {
        return numberOfNights.get();
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights.set(numberOfNights);
    }
}
