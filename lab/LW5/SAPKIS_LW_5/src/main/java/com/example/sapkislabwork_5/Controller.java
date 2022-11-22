package com.example.sapkislabwork_5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public GridPane grid;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 1; i < 9; i++){
            for (int j = 1; j < 9; j++){
                if(i%2!=0){
                    if(j%2==0){
                        grid.add(rectangle(), j, i);
                    }
                }else{
                    if(j%2!=0){
                        grid.add(rectangle(), j, i);
                    }
                }

            }
        }
        char sign = 'A';
        int num = 8;
        for(int i = 1; i < 9; i++){
            grid.add(label(String.valueOf(sign)),  i,0 );
            grid.add(label(String.valueOf(sign)), i,9 );

            grid.add(label(String.valueOf(num)), 9, i );
            grid.add(label(String.valueOf(num)), 0, i );
            sign++;
            num--;
        }
        int[] white = {2, 4, 8, 10, 12, 8, 4, 2};
        int[] black = {3, 5, 7, 9, 11, 7, 5, 3};

        for (int i = 0; i < 8; i++){
            grid.add(image(String.valueOf(black[i])), i+1, 1);
            grid.add(image(String.valueOf(white[i])), i+1, 8);

            grid.add(image("1"), i+1, 2);
            grid.add(image("2"), i+1, 7);
        }
    }
    public ImageView image(String s){
        Image image = new Image("file:"+s+".png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        GridPane.setHalignment(imageView, HPos.CENTER);
        return imageView;
    }
    public Rectangle rectangle(){
        Rectangle rect = new Rectangle(80, 80);
        rect.setFill(Color.GRAY);
        rect.setStroke(Color.GRAY);
        return rect;
    }
    public Label label(String str){
        Label label = new Label(str);
        label.prefWidth(50);
        label.setFont(Font.font("Century Gothic", FontWeight.BOLD, 23));
        GridPane.setHalignment(label, HPos.CENTER);
        return label;
    }
}