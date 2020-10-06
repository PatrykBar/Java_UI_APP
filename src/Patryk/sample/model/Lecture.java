package Patryk.sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lecture {

    private int ID;
    private SimpleStringProperty nameOfLecture;
    private SimpleIntegerProperty personID;
    private SimpleStringProperty summary;
    private SimpleStringProperty dateOfRefer;

    public Lecture() {
        this.nameOfLecture = new SimpleStringProperty();
        this.personID = new SimpleIntegerProperty();
        this.summary = new SimpleStringProperty();
        this.dateOfRefer = new SimpleStringProperty();
    }

    public int getID() {
        return ID;
    }

    public void setLecturesID(int ID) {
        this.ID = ID;
    }

    public String getNameOfLecture() {
        return nameOfLecture.get();
    }

    public void setNameOfLecture(String nameOfLecture) {
        this.nameOfLecture.set(nameOfLecture);
    }

    public int getPersonID() {
        return personID.get();
    }

    public void setPersonID(int personID) {
        this.personID.set(personID);
    }

    public String getSummary() {
        return summary.get();
    }

    public void setSummary(String summary) {
        this.summary.set(summary);
    }

    public String getDateOfRefer() {
        return dateOfRefer.get();
    }

    public void setDateOfRefer(String dateOfRefer) {
        this.dateOfRefer.set(dateOfRefer);
    }
}
