package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ImageManager {

    //FX Elements
    private Canvas imgViewCanvas;


    private Image currentImage;
    private ArrayList<String> imageList;
    private int currentImageIndex = 0;

    public ImageManager(Canvas imgViewCanvas)
    {
        assert imgViewCanvas != null : "fx:id=\"imgView\" was not injected: check your FXML file 'MainInterface.fxml'.";

        this.imgViewCanvas = imgViewCanvas;
        currentImage = new Image("file:..\\..\\images\\image1.jpg");
        PopulateImageList();
    }

    public void NextImage()
    {
        ++currentImageIndex;
        if(currentImageIndex >= imageList.size())
        {
            currentImageIndex = 0;
        }

        currentImage = new Image( imageList.get(currentImageIndex) );
        SetImage();
    }

    public void PreviousImage()
    {
        --currentImageIndex;
        if(currentImageIndex < 0)
        {
            currentImageIndex = imageList.size() - 1;
        }

        currentImage = new Image( imageList.get(currentImageIndex) );
        SetImage();
    }

    // The usual way this list would be populated would be with the folder hierarchy.
    // In this prototype, we will add them manually.
    public void PopulateImageList()
    {
        imageList = new ArrayList<String>();
        imageList.add("file:..\\..\\images\\image1.jpg");
        imageList.add("file:..\\..\\images\\image2.jpg");
    }

    public Image GetImage()
    {

        return currentImage;
    }

    public void SetImage()
    {
        GraphicsContext gc = imgViewCanvas.getGraphicsContext2D();
        gc.drawImage(currentImage, 0, 0, imgViewCanvas.getWidth(), imgViewCanvas.getHeight());



        gc.setFill(Color.BLACK);
        gc.fillOval(imgViewCanvas.getHeight()/4, imgViewCanvas.getWidth()/4, 25, 25);
        gc.fillOval(imgViewCanvas.getHeight()*3/4, imgViewCanvas.getWidth()/4, 25, 25);
        gc.fillOval(imgViewCanvas.getHeight()/2, imgViewCanvas.getWidth()/2, 25, 25);
        gc.fillOval(imgViewCanvas.getHeight()/4, imgViewCanvas.getWidth()*3/4, 25, 25);
        gc.fillOval(imgViewCanvas.getHeight()*3/ 4, imgViewCanvas.getWidth()*3/4, 25, 25);
    }
}
