package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.ImageInformation;

import java.awt.*;
import java.util.ArrayList;

public class ImageManager {

    //FX Elements
    private Canvas imgViewCanvas;

    private Image currentImage;
    public ArrayList<ImageInformation> images = new ArrayList<ImageInformation>();
    private int currentImageIndex = -1;

    public ImageManager(Canvas imgViewCanvas)
    {
        assert imgViewCanvas != null : "fx:id=\"imgView\" was not injected: check your FXML file 'MainInterface.fxml'.";

        this.imgViewCanvas = imgViewCanvas;
        //currentImage = new Image("file:..\\..\\images\\image1.jpg");
        //PopulateImageList();
    }

    public void NextImage()
    {
        if(!images.isEmpty()) {
            ++currentImageIndex;
            if (currentImageIndex >= images.size()) {
                currentImageIndex = 0;
            }

            currentImage = images.get(currentImageIndex).getImage();
            SetImage();
        }
    }

    public void PreviousImage()
    {
        if(!images.isEmpty()) {
            --currentImageIndex;
            if (currentImageIndex < 0) {
                currentImageIndex = images.size() - 1;
            }

            currentImage = images.get(currentImageIndex).getImage();
            SetImage();
        }
    }

    // The usual way this list would be populated would be with the folder hierarchy.
    // In this prototype, we will add them manually.
    public void PopulateImageList()
    {
        /*imageList = new ArrayList<String>();
        imageList.add("file:..\\..\\images\\image1.jpg");
        imageList.add("file:..\\..\\images\\image2.jpg");*/
    }

    public Image GetImage()
    {

        return currentImage;
    }

    public void SetImage()
    {
        GraphicsContext gc = imgViewCanvas.getGraphicsContext2D();
        ImageInformation img = images.get(currentImageIndex);
        imgViewCanvas.setHeight(img.getImage().getHeight());
        imgViewCanvas.setWidth(img.getImage().getWidth());
        gc.drawImage(currentImage, 0, 0, imgViewCanvas.getWidth(), imgViewCanvas.getHeight());

        gc.setFill(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            Point p = img.getPoints()[i];
            gc.fillOval(p.getX(), p.getY(), 25, 25);
            gc.fillText(img.getTypes()[i].toString(), p.x , p.y - 20);
            gc.fillText(String.valueOf(img.getFrequency()[i] * 100) + "%", p.x , p.y - 5);
        }
    }
}
