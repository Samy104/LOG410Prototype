package sample;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import model.ImageInformation;

import javax.imageio.ImageIO;

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

    @FXML
    private MenuItem importItem;

    @FXML
    private MenuItem exportItem;


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert btnNextImage != null : "fx:id=\"btnNextImage\" was not injected: check your FXML file 'MainInterface.fxml'.";
        assert btnPreviousImage != null : "fx:id=\"btnPreviousImage\" was not injected: check your FXML file 'MainInterface.fxml'.";
        assert importItem != null : "Import item was not injected;";
        // Instantiate Manager
        imgMan = new ImageManager(imgViewCanvas);
//        imgMan.NextImage();
    }

    @FXML
    private void handleImportItemAction(ActionEvent event) {
        File fileLocation = new FileChooser().showOpenDialog(Main.stage);
        try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
            String line;
            while ((line = br.readLine()) != null) {
                final File folder = new File(line);
                if(folder.isDirectory()) {
                    listFilesForFolder(folder);
                } else {
                    Image img = new Image(folder.toURI().toString());
                    imgMan.images.add(new ImageInformation(img, folder.toURI().toString(),
                            new ImageInformation.Type[] {
                                    ImageInformation.Type.SAND, ImageInformation.Type.FISH,
                                    ImageInformation.Type.ALGA, ImageInformation.Type.CORAL,
                                    ImageInformation.Type.SAND
                            },
                            new Point[] {
                                    new Point((int)(img.getWidth() * 0.25), (int)(img.getHeight() * 0.25)),
                                    new Point((int)(img.getWidth() * 0.75), (int)(img.getHeight() * 0.25)),
                                    new Point((int)(img.getWidth() * 0.5), (int)(img.getHeight() * 0.5)),
                                    new Point((int)(img.getWidth() * 0.25), (int)(img.getHeight() * 0.75)),
                                    new Point((int)(img.getWidth() * 0.75), (int)(img.getHeight() * 0.75))
                            },
                            new double[] {
                                    0.86, 0.76, 0.99, 0.65, 0.54
                            }
                    ));
                }
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        imgMan.NextImage();
    }

    @FXML
    private void handleExportItemAction(ActionEvent event) {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("imageInformation.csv"), "UTF-8"));
            for (ImageInformation img : imgMan.images)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(img.getPath());
                oneLine.append(";");
                for(Point p : img.getPoints()) {
                    oneLine.append(p.getX() + "," + p.getY());
                }
                oneLine.append(";");
                for(ImageInformation.Type t : img.getTypes()) {
                    oneLine.append(t.toString());
                }
                oneLine.append(";");
                for(double d : img.getFrequency()) {
                    oneLine.append(d + ",");
                }
                oneLine.append(";");
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
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


    private void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                    Image img = new Image(fileEntry.toURI().toString());
                    imgMan.images.add(new ImageInformation(img, fileEntry.toURI().toString(),
                            new ImageInformation.Type[] {
                                    ImageInformation.Type.SAND, ImageInformation.Type.FISH,
                                    ImageInformation.Type.ALGA, ImageInformation.Type.CORAL,
                                    ImageInformation.Type.SAND
                            },
                            new Point[] {
                                    new Point((int)(img.getWidth() * 0.25), (int)(img.getHeight() * 0.25)),
                                    new Point((int)(img.getWidth() * 0.75), (int)(img.getHeight() * 0.25)),
                                    new Point((int)(img.getWidth() * 0.5), (int)(img.getHeight() * 0.5)),
                                    new Point((int)(img.getWidth() * 0.25), (int)(img.getHeight() * 0.75)),
                                    new Point((int)(img.getWidth() * 0.75), (int)(img.getHeight() * 0.75))
                            },
                            new double[] {
                                    0.86, 0.76, 0.99, 0.65, 0.54
                            }
                    ));
            }
        }
    }
}
