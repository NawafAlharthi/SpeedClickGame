package Panes;

import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TopScoresPane extends VBox {

    Label label = new Label("TOP SCORES");
   public TopScoresPane(ArrayList<Integer> scores){
        label.setFont(new Font(24));
        this.getChildren().add(label);
        Collections.sort(scores, Collections.reverseOrder());
        Iterator<Integer> iterator = scores.iterator();
        int index = 1;
        while (iterator.hasNext() && index <= 5){
            String score = index + ": "  +  Integer.toString(iterator.next());
            Label scoreLabel = new Label(score);
            scoreLabel.setFont(new Font(18));
            this.getChildren().add(scoreLabel);
            index++;
        }
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(100, 100);
        this.setStyle("-fx-background-color: gray");
    }
}
