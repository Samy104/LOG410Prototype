package sample;

import com.mrlonee.radialfx.settingsmenu.RadialSettingsMenu;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;




public class Main extends Application {



    private Group container;
    private RadialSettingsMenu radialMenu;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Prepare canvas
        /*ImageView iv = new ImageView(imgMan.getImage());
        Canvas canvas = new Canvas(300, 250);
        final GraphicsContext gc = canvas.getGraphicsContext2D();*/

        //Prepare the UI Template
        Parent root = FXMLLoader.load(getClass().getResource("MainInterface.fxml"));

        container = new Group(root);
        final Scene scene = new Scene(container);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1280);
        primaryStage.setHeight(1080);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Reef Inspector");

        radialMenu = new RadialSettingsMenu();
        container.getChildren().addAll(radialMenu);
        radialMenu.setVisible(false);

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                    radialMenu.setTranslateX(event.getX());
                    radialMenu.setTranslateY(event.getY());
                    radialMenu.setVisible(true);
                } else {
                    radialMenu.setVisible(false);
                }
            }
        });

        primaryStage.show();
    }

}
