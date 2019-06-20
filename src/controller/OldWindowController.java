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

public class OldWindowController {

    @FXML
    private Button btnBack, btnRSR, btnRQD, btnTerzaghi;

    @FXML
    void goMain(ActionEvent event) throws IOException {
        Parent parent = new FXMLLoader().load(getClass().getResource("/views/main.fxml"));
        Scene scene = new Scene(parent);
        Image icon = new Image("/img/icMineria.png");
        Stage stage = new Stage();
        stage.setTitle("Menú");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
        //Hide the actual window (Login window)
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void viewRQD(ActionEvent event) {

    }

    @FXML
    void viewRSR(ActionEvent event) {

    }

    @FXML
    void viewTerzaghi(ActionEvent event) throws IOException {
        Parent parent = new FXMLLoader().load(getClass().getResource("/views/old/terzaghi.fxml"));
        Scene scene = new Scene(parent);
        Image icon = new Image("/img/icMineria.png");
        Stage stage = new Stage();
        stage.setTitle("Clasificación Terzaghi");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
        //Hide the actual window (Login window)
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

}
