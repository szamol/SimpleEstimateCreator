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
import sample.DocumentManger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable{

    @FXML
    private TextField clientId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void buttonHandler(ActionEvent e) throws IOException{
        DocumentManger.addClientToDocument(clientId.getText());

        Parent root3 = FXMLLoader.load(getClass().getResource("resources/View/ServicesView.fxml"));
        Scene scene3 = new Scene(root3);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
    }
}
