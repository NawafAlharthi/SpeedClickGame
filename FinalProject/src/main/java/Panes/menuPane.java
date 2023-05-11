package Panes;

import com.example.projectf.customButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class menuPane extends VBox {

    private Button playButton = new customButton("PLAY");
    private Button quitButton = new customButton("QUIT");
    private TopScoresPane topScoresPane;

    public menuPane(ArrayList<Integer> scores){
        topScoresPane = new TopScoresPane(scores);
        Label label = new Label("GAME OVER");
        label.setFont(new Font("Arial Black", 48));
        setSpacing(20);
        setPadding(new Insets(20));
        setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        setAlignment(Pos.CENTER);
        setEffect(new DropShadow(10, Color.GRAY)); // add a subtle drop shadow effect
        getChildren().addAll(topScoresPane, label, playButton, quitButton);
    }



    public menuPane(){
        Label label = new Label("     WELCOME Back" + '\n' + "TO Speed Click Game");
        label.setFont(new Font("Arial Black", 48));
        setSpacing(20);
        setPadding(new Insets(20));
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setAlignment(Pos.CENTER);
        getChildren().addAll(label, playButton, quitButton);
    }

    public Button getStartButton() {
        return playButton;
    }
    public ButtonBase getQuitButton() {
        return quitButton;
    }
}

