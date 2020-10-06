package Patryk.sample.fxmlFiles;

import Patryk.sample.model.Datasource;
import Patryk.sample.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class updateController {

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField academyTitle;

    @FXML
    private TextField academyID;

    @FXML
    private TextField departmentID;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField email;


    public void addNewValue(Person person) {

        String newName = person.getName();
        String newSurname = person.getSurname();
        String newAcademyTitle = person.getAcademicTitle();
        int newAcademy = person.getAcademyID();
        int newDepartment = person.getDepartmentID();
        int newPhoneNumber = person.getDepartmentID();
        String newEmail = person.getEmailAddress();
        int IDPerson = person.getID();

        if (!name.getText().isEmpty()) {
            newName = name.getText().trim();
        }

        if (!surname.getText().isEmpty()) {
            newSurname = surname.getText().trim();
        }

        if (!academyTitle.getText().isEmpty()) {
            newAcademyTitle = academyTitle.getText().trim();
        }

        if (!academyID.getText().isEmpty()) {
            newAcademy = Integer.getInteger(academyID.getText().trim());
        }

        if (!departmentID.getText().isEmpty()) {
            newDepartment = Integer.getInteger(departmentID.getText().trim());
        }

        if (!phoneNumber.getText().isEmpty()) {
            newPhoneNumber = Integer.getInteger(phoneNumber.getText().trim());
        }

        if (!email.getText().isEmpty()) {
            newEmail = email.getText().trim();
        }

        Datasource.getInstance().updatePersonMethod(newName, newSurname, newAcademyTitle, newAcademy, newDepartment, newPhoneNumber, newEmail, IDPerson);

    }

}