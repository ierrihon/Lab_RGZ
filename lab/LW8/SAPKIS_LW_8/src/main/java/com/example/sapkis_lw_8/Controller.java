package com.example.sapkis_lw_8;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button btnTargetConf, btnNumConfP2, btnStartGame, btnNumConfP1;
    public TextField textTarget, textNumP1, textNumP2;
    public Label lblTargetNum, lblCurNum;
    int target = 0;
    int timer = 0;
    boolean tempBool = false;
    boolean gameStart = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnTargetConf.setOnAction(event -> {
            if(textTarget.getText() != null){
                try{
                    int temp = Integer.parseInt(textTarget.getText());
                    if(temp <= 1){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Помилка");
                        alert.setHeaderText("Число-ціль повинно буди більше одиниці");
                        alert.showAndWait();
                    }else{
                        target = temp;
                        lblTargetNum.setText(String.valueOf(target));
                    }
                }catch (NumberFormatException e){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Помилка");
                    alert.setHeaderText("Не правильний формат числа");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Помилка");
                alert.setHeaderText("Ви не задали число-ціль!");
                alert.showAndWait();
            }
        });
        btnNumConfP2.setOnAction(event -> {
            if(gameStart) {
                if (tempBool) {
                    checkNumP(textNumP2.getText());
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Помилка");
                    alert.setHeaderText("Зараз черка гравця 1");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Помилка");
                alert.setHeaderText("Ви не почали гру");
                alert.showAndWait();
            }
        });

        btnNumConfP1.setOnAction(event -> {
            if(gameStart) {
                if(!tempBool){
                    checkNumP(textNumP1.getText());
                }else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Помилка");
                    alert.setHeaderText("Зараз черка гравця 2");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Помилка");
                alert.setHeaderText("Ви не почали гру");
                alert.showAndWait();
            }
        });

        btnStartGame.setOnAction(event -> {
            if(target != 0){
                lblCurNum.setText("1");
                changeTempBool();
                timer++;
                gameStart = true;
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Помилка");
                alert.setHeaderText("Ви не задали число-ціль!");
                alert.showAndWait();
            }
        });
    }

    public void checkNumP(String str){
        if(str != null){
            try {
                int strToInt = Integer.parseInt(str);
                if(strToInt > 1 && strToInt < 10){
                    int temp = Integer.parseInt(lblCurNum.getText()) * strToInt;
                    lblCurNum.setText(String.valueOf(temp));
                    if(temp >= target){
                        if(!tempBool) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Перемога");
                            alert.setHeaderText("Переміг гравець 1\nКількість кроків: " + timer);
                            alert.showAndWait();
                            clear();
                        }else{
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Перемога");
                            alert.setHeaderText("Переміг гравець 2\nКількість кроків: " + timer);
                            alert.showAndWait();
                            clear();
                        }
                    }
                    timer++;
                    changeTempBool();
                }else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Помилка");
                    alert.setHeaderText("Не правильний формат числа");
                    alert.showAndWait();
                }
            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Помилка");
                alert.setHeaderText("Не правильний формат числа");
                alert.showAndWait();
            }
        }
    }

    public void changeTempBool(){
        tempBool = !tempBool;
    }
    public void clear(){
        lblTargetNum.setText("0000000");
        lblCurNum.setText("0000000");
        textNumP1.setText("");
        target = 0;
        gameStart = false;
    }
}