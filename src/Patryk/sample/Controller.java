package Patryk.sample;

import Patryk.sample.fxmlFiles.lectureController;
import Patryk.sample.fxmlFiles.updateController;
import Patryk.sample.model.Datasource;
import Patryk.sample.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class Controller {

    @FXML
    private TableView personTable;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField academyTitleField;
    @FXML
    private TextField academyIDField;
    @FXML
    private TextField departmentIDField;
    @FXML
    private TextField phoneNumberFiled;
    @FXML
    private TextField emialFiled;
    private int academyID;

    @FXML
    public void listPersons(){
        Task<ObservableList<Person>> task = new GetAllPersonsTask();
        personTable.itemsProperty().bind(task.valueProperty());

        progressBar.progressProperty().bind(task.progressProperty());
        progressBar.setVisible(true);

        task.setOnSucceeded(e-> progressBar.setVisible(false));
        task.setOnFailed(e-> progressBar.setVisible(false));

        new Thread(task).start();
    }

    @FXML
    public void listLectures(){
        final Person person = (Person) personTable.getSelectionModel().getSelectedItem();
        if(person == null) {
            System.out.println("NO PERSON SELECTED");
            return;
        }
        else {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/lecturesForPerson.fxml"));
            try{
                Stage Stage = new Stage();
                Stage.setTitle("Lectures");
                Stage.setScene(new Scene(fxmlLoader.load(), 800, 600));

                lectureController lectureController = fxmlLoader.getController();
                lectureController.init(person);

                Stage.show();

            }catch (IOException e){
                System.out.println("Couldn't load the dialog");
                e.printStackTrace();
                return;
            }

        }
    }

    @FXML
    public void updatePerson(){

        final Person person = (Person) personTable.getSelectionModel().getSelectedItem();
        if(person == null) {
            System.out.println("NO PERSON SELECTED");
        }
        else {

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Update Person");
            dialog.initOwner(mainBorderPane.getScene().getWindow());

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/updatePersonWin.fxml"));

            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                System.out.println("Couldn't load the dialog");
                e.printStackTrace();
            }


            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            Optional<ButtonType> result = dialog.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                System.out.println("OK");
                updateController updateController = fxmlLoader.getController();
                updateController.addNewValue(person);
            } else {
                System.out.println("CANCEL");
            }

        }

    }

    @FXML
    public void insertPerson() throws SQLException {

        Person person = new Person();

        int academyID = 0;
        int departmentID = 0;
        int phoneNumber = 0;

        String name = nameField.getText();
        String surname = surnameField.getText();
        academyID = Integer.parseInt(academyIDField.getText());
        String academyTitle = academyTitleField.getText();
        departmentID = Integer.parseInt(departmentIDField.getText());
        phoneNumber = Integer.parseInt(phoneNumberFiled.getText());
        String email = emialFiled.getText();

        if(name != null && surname != null && academyID != 0 && academyTitle != null && departmentID != 0 && phoneNumber != 0 && email != null) {

            person.setName(name);
            person.setSurname(surname);
            person.setAcademyID(academyID);
            person.setAcademicTitle(academyTitle);
            person.setDepartmentID(departmentID);
            person.setPhoneNumber(phoneNumber);
            person.setEmailAddress(email);

            Datasource.getInstance().insertPerson(person.getName(), person.getSurname(), person.getAcademicTitle(),
                    person.getAcademyID(), person.getDepartmentID(), person.getPhoneNumber(), person.getEmailAddress());
        }else {
            System.out.println("ERROR WRONG INPUT DATA");
        }
    }

    @FXML
    public void insertDinner() {
    }

    @FXML
    public void insertRoom(){

    }
}

class GetAllPersonsTask extends Task {

    @Override
    public ObservableList<Person> call() {
        return FXCollections.observableArrayList(
                Datasource.getInstance().queryPersons(Datasource.ORDER_BY_ASC));
    }
}