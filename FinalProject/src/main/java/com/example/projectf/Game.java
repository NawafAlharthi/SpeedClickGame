package com.example.projectf;

import Panes.GamePane;
import Panes.menuPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class Game extends Application {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 600;
    private final static double TIME_PER_TICK = 0.01;
    private int spawnDuration = 2000; // in milliseconds
    private GamePane gamePane;
    private Timeline timeline;
    private Stage stage;
    private Scene scene;
    private ArrayList<Integer> scores = new ArrayList<>();
    private menuPane menuPane;

    private ArrayList<FallingObject> objects = new ArrayList<>();


    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        menuPane = new menuPane();
        scene = new Scene(menuPane,WIDTH,HEIGHT);
        menuPane.getStartButton().setOnAction(e-> startGame());
        menuPane.getQuitButton().setOnAction(e-> stage.close());
        stage.setTitle("menu");
        stage. setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    void startGame(){
        gamePane = new GamePane();
        EventHandler<ActionEvent> eventHandler = e-> {
            if (!gamePane.run()){
                timeline.stop();
                setMenuPane();
            }
        };
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(TIME_PER_TICK), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        scene = new Scene(gamePane,WIDTH,HEIGHT);
        stage.setTitle("game");
        stage. setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    void setMenuPane(){
        scores.add(gamePane.getScore());
        menuPane = new menuPane(scores);
        scene = new Scene(menuPane,WIDTH,HEIGHT);
        menuPane.getStartButton().setOnAction(e-> startGame());
        menuPane.getQuitButton().setOnAction(e-> stage.close());
        stage.setTitle("menu");
        stage. setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}