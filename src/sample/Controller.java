package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

public class Controller implements Initializable
{
    // Managers
    ImageManager imgMan;

    // FXML elements
    @FXML
    private Button btnNextImage;

    @FXML
    private Button btnPreviousImage;

    @FXML
    private Canvas imgViewCanvas;


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert btnNextImage != null : "fx:id=\"btnNextImage\" was not injected: check your FXML file 'MainInterface.fxml'.";
        assert btnPreviousImage != null : "fx:id=\"btnPreviousImage\" was not injected: check your FXML file 'MainInterface.fxml'.";

        // Instantiate Manager
        imgMan = new ImageManager(imgViewCanvas);
        imgMan.NextImage();
    }

    // Controllers
    @FXML
    private void handleNextImageAction(ActionEvent event)
    {
        System.out.println("NEXT PRESSED");

        // Call the next image
        imgMan.NextImage();
    }

    @FXML
    private void handlePrevImageAction(ActionEvent event)
    {
        System.out.println("PREV PRESSED");

        // Call the previous image
        imgMan.PreviousImage();
    }

}
