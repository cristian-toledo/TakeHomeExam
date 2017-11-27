/*Cristian Toledo
Take Home Test
Question #1
Due:11-26-17
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.media.AudioClip;

public class Question1 extends Application {
    public void start(Stage primaryStage) {
        // These are the Three buttons that control the app
        Button play = new Button("Play");
        Button loop = new Button("Loop");
        Button stop = new Button("Stop");

        // The Pane's Dimensions
        HBox pane = new HBox(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().addAll(play, loop, stop);

        // Grabbing Audio from links
        AudioClip audio = new AudioClip(
                "http://cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3");

        play.setOnAction(e -> {
            audio.play();
        });

        stop.setOnAction(e -> {
            audio.stop();
        });

        loop.setOnAction(e -> {
            audio.setCycleCount(AudioClip.INDEFINITE);
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question #1 ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}