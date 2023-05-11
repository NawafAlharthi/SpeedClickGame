package Panes;
import com.example.projectf.FallingObject;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class GamePane extends Pane {
    private final static int HEIGHT = 600;
    private double dS = 0.1;
    private double speed = 1;
    private int RADIUS = 40;
    private int numberOfObjects = 60;
    private int spawnedObjects = 0;
    private int eliminatedObjects = 0;

    private int score = 0;
    private Label scoreLabel;
    private static double startTime = System.currentTimeMillis();

    private int spawnDuration = 2000; // in milliseconds
    private ArrayList<FallingObject> objects = new ArrayList<>();



    public GamePane() {
        scoreLabel = new Label("SCORE: "+score);
        scoreLabel.setLayoutX(20);
        scoreLabel.setLayoutY(10);
        scoreLabel.setStyle("-fx-text-fill: black; -fx-font-size: 36px; -fx-font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; -fx-font-weight: bold; -fx-background-color: #f2f2f2; -fx-border-color: #000000; -fx-border-width: 2px; -fx-padding: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 5);");
        scoreLabel.setMouseTransparent(true);
        this.getChildren().add(scoreLabel);
    }






    private void spawnObjects(int n, double s) {
        ArrayList<Integer> objectsSpawnCoordinate = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int spawnCoordinate = 0;
            boolean stacked = true;
            while (stacked) {
                spawnCoordinate = (int) (Math.random() * 720) + 40;
                stacked = false;
                for (int coordinate : objectsSpawnCoordinate) {
                    if (spawnCoordinate >= coordinate - RADIUS * 2 && spawnCoordinate <= coordinate + RADIUS * 2) {
                        stacked = true;
                    }
                }
            }
            objectsSpawnCoordinate.add(spawnCoordinate);
            FallingObject circle = new FallingObject(s, spawnCoordinate);
            circle.setOnMousePressed(e -> {
                if(e.isPrimaryButtonDown()) {
                    circle.vanish(this);
                    eliminatedObjects++;
                    objects.remove(circle);
                    score += circle.getPoints();
                    scoreLabel.setText("SCORE: " + score);
                }
            });

            objects.add(circle);
            this.getChildren().addAll(circle, circle.getText());
        }
    }


    private void move() {
        for (int i = 0; i<objects.size(); i++) {
            FallingObject circle = objects.get(i);
            if (circle.getCenterY() - RADIUS >= HEIGHT) {
                eliminatedObjects++;
                objects.remove(circle);
                i--;
            }
            else {
                double position = circle.getCenterY() + circle.getSpeed();
                circle.setCenterY(position);
                circle.getText().setY(position);
            }
        }
    }




    public boolean run(){
        move();
        if(System.currentTimeMillis()-startTime>spawnDuration && spawnedObjects != numberOfObjects ){
            int rndNumberObject = (int)(Math.random()*2)+1;
            while (rndNumberObject + spawnedObjects >numberOfObjects){
                rndNumberObject = (int)(Math.random()*2)+1;
            }
            spawnedObjects+=rndNumberObject;
            spawnObjects(rndNumberObject,speed);
            speed+=dS;
            startTime = System.currentTimeMillis();
            spawnDuration = (int)(Math.random()*1500/speed) + 500;
        }
        return eliminatedObjects != numberOfObjects;
    }


    public int getScore() {
        return score;
    }
}
