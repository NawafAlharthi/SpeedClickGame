package com.example.projectf;

import javafx.scene.control.Button;

public class customButton extends Button {
    public customButton(String text){
        super(text);
        this.setStyle("-fx-background-color: white; -fx-background-radius: 20px; -fx-font-size: 24; -fx-text-fill: black;");
        this.setOnMouseEntered(event ->  this.setStyle("-fx-background-color: black; -fx-background-radius: 20px; -fx-font-size: 24; -fx-text-fill: white;"));
        this.setOnMouseExited(mouseEvent -> this.setStyle("-fx-background-color: white; -fx-background-radius: 20px; -fx-font-size: 24; -fx-text-fill: black;"));
        this.setMinWidth(200);

    }

}

