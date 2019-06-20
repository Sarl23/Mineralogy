package controller.old;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.old.Terzaghi;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class TerzaghiController implements Initializable {

    private Terzaghi terzaghi;
    private String result[] = null;
    private String number = "";
    private Alert alert;
    @FXML
    private ComboBox<String> cbCondition;
    @FXML
    private ToggleGroup options;
    @FXML
    private RadioButton rbYes, rbNo;
    @FXML
    private TextField txWidth, txHeight, txWeight;
    @FXML
    private Label lbHpInitial, lbHpFinal, lbObservation;
    @FXML
    private Button goOldClassification, btnCalculate;
    private ObservableList<String> cbItems = FXCollections.observableArrayList();

    @FXML
    void selectItem(ActionEvent event) {
        if(cbCondition.getValue().charAt(1) == '0'){
            txWeight.setDisable(true);
        } else if(cbCondition.getValue().charAt(2) == '1'){
             txWeight.setDisable(false);
        } else if(cbCondition.getValue().charAt(0) == '1'){
            txWeight.setDisable(true);
        } else if(cbCondition.getValue().charAt(0) == '2'){
            txWeight.setDisable(true);
        } else if(cbCondition.getValue().charAt(0) == '3'){
            txWeight.setDisable(true);
        } else if(cbCondition.getValue().charAt(0) == '4'){
            txWeight.setDisable(true);
        } else if(cbCondition.getValue().charAt(0) == '5'){
            txWeight.setDisable(true);
        } else if(cbCondition.getValue().charAt(0) == '6'){
            txWeight.setDisable(true);
        } else if(cbCondition.getValue().charAt(0) == '7'){
            txWeight.setDisable(false);
        } else if(cbCondition.getValue().charAt(0) == '8'){
            txWeight.setDisable(true);
        } else if(cbCondition.getValue().charAt(0) == '9'){
            txWeight.setDisable(true);
        }
        btnCalculate.setDisable(false);
    }

    @FXML
    void calculate(ActionEvent event){
        if(cbCondition.getValue().charAt(0) == '7'){
            if(txHeight.getText().length() > 0 && txWidth.getText().length() > 0 && txWeight.getText().length() > 0){
                if( String.valueOf(cbCondition.getValue().charAt(2)).equals(" ") ){
                    number = "7";
                } else {
                    number = "7.1";
                }
                result = terzaghi.calculate( number, Double.parseDouble(txWidth.getText()),
                        Double.parseDouble(txHeight.getText())).split(",");
                lbHpInitial.setText( result[0] );
                lbHpFinal.setText( result[1] );
                lbObservation.setText( terzaghi.getObservation(number) );
                //result = terzaghi.calculateWeight(Double.parseDouble(txWeight.getText())).split(",");
            } else {
                showAlert();
            }
        } else {
            if(txHeight.getText().length() > 0 && txWidth.getText().length() > 0){
                result = terzaghi.calculate(String.valueOf(cbCondition.getValue().charAt(0)), Double.parseDouble(txWidth.getText()),
                        Double.parseDouble(txHeight.getText())).split(",");
                lbHpInitial.setText( result[0] );
                lbHpFinal.setText( result[1] );
                lbObservation.setText( terzaghi.getObservation(String.valueOf(cbCondition.getValue().charAt(0))) );
            } else {
                showAlert();
            }
        }
    }

    private void showAlert() {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText("Hay campos vacíos");
        alert.showAndWait();
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        terzaghi = new Terzaghi();
        txHeight.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    txHeight.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        txWidth.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    txWidth.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        txWeight.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    txWeight.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        cbItems.addAll( ("1. Dura e intacta,2. Dura pero estratificada o esquistosa," +
                "3. Masiva ligeramente fracturada,4. Moderadamente fraturada en bloques abiertos,5. Muy blocosa fisurada y fracmentada," +
                "6. Completamente trozada," + "7. Grava y arena  densa,7.1 Grava y arena,8. Comprimida Profundidad moderada," +
                "9. Comprimida gran profundidad,10. Expansiva").split(","));
        cbCondition.setItems(cbItems);
    }
}
