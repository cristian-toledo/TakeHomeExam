/*Cristian Toledo
Take Home Test
Question #2
Due:11-26-17
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.util.Duration;

public class Question2 extends Application {
    TextField Speed = new TextField();
    TextField Prefix = new TextField();
    TextField NumberOfImages = new TextField();
    TextField URL = new TextField();
    StackPane paneForImage = new StackPane();
    Timeline animation;
    int n = 1;

    public void start(Stage primaryStage) {
        final int COLUMN_COUNT = 27;
        Speed.setPrefColumnCount(COLUMN_COUNT);
        Prefix.setPrefColumnCount(COLUMN_COUNT);
        NumberOfImages.setPrefColumnCount(COLUMN_COUNT);
        URL.setPrefColumnCount(COLUMN_COUNT);

        Button StartBt = new Button("Start Animation");
        GridPane paneForInfo = new GridPane();
        paneForInfo.setAlignment(Pos.CENTER);
        paneForInfo.add(new Label("Enter information for animation"), 0, 0);
        paneForInfo.add(new Label("Animation speed in milliseconds"), 0, 1);
        paneForInfo.add(Speed, 1, 1);
        paneForInfo.add(new Label("Image file prefix"), 0, 2);
        paneForInfo.add(Prefix, 1, 2);
        paneForInfo.add(new Label("Number of images"), 0, 3);
        paneForInfo.add(NumberOfImages, 1, 3);
        paneForInfo.add(new Label("Audio file URL"), 0, 4);
        paneForInfo.add(URL, 1, 4);
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForInfo);
        pane.setCenter(paneForImage);
        pane.setTop(StartBt);
        pane.setAlignment(StartBt, Pos.TOP_RIGHT);
        animation = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> nextImage()));
        animation.setCycleCount(Timeline.INDEFINITE);
        StartBt.setOnAction(e -> {
            if (URL.getText().length() > 0) {
                MediaPlayer mediaPlayer = new MediaPlayer(
                        new Media(URL.getText()));
                mediaPlayer.play();
            }
            if (Speed.getText().length() > 0)
                animation.setRate(Integer.parseInt(Speed.getText()));
            animation.play();
        });

        Scene scene = new Scene(pane, 550, 680);
        primaryStage.setTitle("Question #2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void getImage() {
        paneForImage.getChildren().clear();
        paneForImage.getChildren().add(new ImageView(new Image(
                "http://cs.armstrong.edu/liang/common/image/" +
                        Prefix.getText() + n + ".gif")));
    }
    private void nextImage() {
        n = n < Integer.parseInt(
                NumberOfImages.getText()) ? n += 1 : 1;
        getImage();
    }
}
