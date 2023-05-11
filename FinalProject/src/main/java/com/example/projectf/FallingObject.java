package com.example.projectf;

import Panes.GamePane;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class FallingObject extends Circle {
    double speed;
    int points;
    int radius = 40;
    Text text;
    public FallingObject(double speed,int x){
        this.speed = speed;
        this.setCenterY(-50);
        this.setCenterX(x);
        this.setFill(Color.BLACK);
        this.setRadius(radius);
        points = (int) (Math.random() * 10) + 1;
        text = new Text(String.valueOf(points));
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        text.setFill(Color.WHITE);
        text.setX(this.getCenterX() - (text.getBoundsInLocal().getWidth() / 2));
        text.setY(this.getCenterY() + (text.getBoundsInLocal().getHeight() / 2));
        text.setMouseTransparent(true);
    }

    public void vanish(GamePane gamePane){
        ScaleTransition st = new ScaleTransition(Duration.millis(200), this);
        ScaleTransition st1 = new ScaleTransition(Duration.millis(200), this.getText());
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(0);
        st.setToY(0);
        st1.setFromX(1);
        st1.setFromY(1);
        st1.setToX(0);
        st1.setToY(0);
        st.setOnFinished(event->{
            gamePane.getChildren().removeAll(this, this.getText());
        });
        st.play();
        st1.play();
    }

    public double getSpeed() {
        return speed;
    }

    public Text getText(){return text;}
    public int getPoints(){return points;}
}
