package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class ImageManager {

    private Image currentImage;
    private ArrayList<String> imageList;
    private int currentImageIndex = 0;

    public ImageManager()
    {
        currentImage = new Image("file:image/image1.jpg");
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
    }

    public void PreviousImage()
    {
        --currentImageIndex;
        if(currentImageIndex < 0)
        {
            currentImageIndex = imageList.size() - 1;
        }

        currentImage = new Image( imageList.get(currentImageIndex) );

    }

    // The usual way this list would be populated would be with the folder hierarchy.
    // In this prototype, we will add them manually.
    public void PopulateImageList()
    {
        imageList = new ArrayList<String>();
        imageList.add("file:image/image1.jpg");
        imageList.add("file:image/image2.jpg");
    }

    public Image GetImage()
    {

        return currentImage;
    }
}
