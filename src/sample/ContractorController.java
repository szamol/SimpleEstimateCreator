package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContractorController implements Initializable {

    @FXML
    private TextField companyId, nameId, cityId, adressId, phoneId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void buttonHandler(ActionEvent e) throws IOException {
        DocumentManger.addContractorToDocument(companyId.getText(), nameId.getText(), cityId.getText(), adressId.getText(), phoneId.getText());

        Parent root2 = FXMLLoader.load(getClass().getResource("resources/View/ClientView.fxml"));
        Scene scene2 = new Scene(root2);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
}





