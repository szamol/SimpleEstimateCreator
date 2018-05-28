package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class ModifyBaseController implements Initializable {

    @FXML
    ListView<String> listOfServices;

    @FXML
    TextField newServiceId;

    ObservableList<String> jsonList;

    JsonManager manager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        manager = new JsonManager();

        jsonList = manager.readFromJson();

        listOfServices.setItems(jsonList);
    }

    public void addButtonHandler() {
        if(!newServiceId.getText().isEmpty()) {
            jsonList.add(newServiceId.getText());
        }
    }

    public void removeButtonHandler() {
        jsonList.remove(listOfServices.getSelectionModel().getSelectedIndex());
    }

    public void saveButtonHandler() {
        manager.writeToJson(jsonList);
    }
}
