package Patryk.sample.fxmlFiles;

import Patryk.sample.model.Datasource;
import Patryk.sample.model.Lecture;
import Patryk.sample.model.Person;
import javafx.concurrent.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;


public class lectureController {

    @FXML
    private TableView lecturesTable;

    public void init(Person person){

        GetLectureTesk getLectureTesk = new GetLectureTesk();
        getLectureTesk.setPerson(person);
        Task<ObservableList<Lecture>> task = getLectureTesk;
        lecturesTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

}

class GetLectureTesk extends Task{
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    protected Object call() throws Exception {
        return FXCollections.observableArrayList
                (Datasource.getInstance().queryLectureForPersonId(person.getID()));
    }
}