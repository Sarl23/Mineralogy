package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btnClOld, btnModern, btnExcalavilidad, btnExit;

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void viewEscalavilidad(ActionEvent event) {

    }

    @FXML
    void viewModernClassification(ActionEvent event) {

    }

    @FXML
    void viewOldClassification(ActionEvent event) throws IOException {
        Parent parent = new FXMLLoader().load(getClass().getResource("/views/old/oldClassification.fxml"));
        Scene scene = new Scene(parent);
        Image icon = new Image("/img/icMineria.png");
        Stage stage = new Stage();
        stage.setTitle("Clasificaciones antiguas");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
        //Hide the actual window (Login window)
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

}
