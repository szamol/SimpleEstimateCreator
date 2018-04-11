package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SummaryController implements Initializable {

    @FXML
    Label laborCostId;

    @FXML
    TextField materialsCostId;

    @FXML
    CheckBox isVatAddedCheckBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        laborCostId.setText(String.valueOf(Service.laborCost) + ",-");
    }

    public void saveButtonHandler() {
        DocumentManger.addSummaryToDocument(Service.laborCost, Integer.parseInt(materialsCostId.getText()), isVatAddedCheckBox.isSelected());
        DocumentManger.saveDocument();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zapis");
        alert.setHeaderText("Pomyślnie zapisano!");
        alert.showAndWait();
    }
}
