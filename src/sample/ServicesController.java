package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ServicesController implements Initializable, InputValidation {

    @FXML
    TableView<Service> table;

    @FXML
    TableColumn<Service, String> nameCol;

    @FXML
    TableColumn<Service, Integer> amountCol, priceCol, sumCol;

    @FXML
    TextField nameInputId, amountInputId, priceInputId;

    @FXML
    ChoiceBox<String> unitChoiceBoxId;

    @FXML
    ListView<String> servicesNames;

    private ObservableList<Service> serviceList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        sumCol.setCellValueFactory(new PropertyValueFactory<>("sum"));

        JsonManager manager = new JsonManager();
        servicesNames.setItems(manager.readFromJson());

        servicesNames.getSelectionModel().selectedItemProperty().addListener(e -> nameInputId.setText(servicesNames.getSelectionModel().getSelectedItem()));
    }

    public void addNewService() {
        if(!nameInputId.getText().isEmpty() && !amountInputId.getText().isEmpty() && !priceInputId.getText().isEmpty()) {
            serviceList.add(new Service(nameInputId.getText(), Integer.parseInt(amountInputId.getText()), unitChoiceBoxId.getValue(), Integer.parseInt(priceInputId.getText())));
            table.setItems(serviceList);
            nameInputId.clear();
            amountInputId.clear();
            priceInputId.clear();
        }
    }

    public void modifyBaseHandler() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("resources/View/ModifyBaseView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Modyfikacja bazy usług");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnCloseRequest(e-> {
                JsonManager manager = new JsonManager();
                servicesNames.setItems(manager.readFromJson());
            });
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void nextButtonHandler(ActionEvent e) throws IOException{
        if(validation()) {
            DocumentManger.addServicesToDocument(serviceList);
            Parent root4 = FXMLLoader.load(getClass().getResource("resources/View/SummaryView.fxml"));
            Scene scene4 = new Scene(root4);

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
            window.setScene(scene4);
            window.show();
        } else popAlert();
    }

    @Override
    public boolean validation() {
        return !serviceList.isEmpty();
    }

    @Override
    public void popAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Błąd!");
        alert.setHeaderText("Brak pozycji na liście!");
        alert.showAndWait();
    }
}
