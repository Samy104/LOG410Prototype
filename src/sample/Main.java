package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

// Canevas
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;


public class Main extends Application {

    ImageManager imgMan;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Instantiate Manager
        imgMan = new ImageManager();

        // Prepare canvas
        /*ImageView iv = new ImageView(imgMan.getImage());
        Canvas canvas = new Canvas(300, 250);
        final GraphicsContext gc = canvas.getGraphicsContext2D();*/

        //Prepare the UI Template
        Parent root = FXMLLoader.load(getClass().getResource("MainInterface.fxml"));
        primaryStage.setTitle("Reef Inspector");
        primaryStage.setScene(new Scene(root, 1280, 1080));

        primaryStage.show();
    }

    public void nextImage(GraphicsContext gc)
    {
        Image currentImage = imgMan.GetImage();
        gc.drawImage(currentImage, currentImage.getHeight(), currentImage.getWidth());
    }

}
