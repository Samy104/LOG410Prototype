package model;

import javafx.scene.image.Image;

import java.awt.*;
import java.util.Map;

/**
 * Created by serge on 2015-11-02.
 */
public class ImageInformation {
    public enum Type {
        SAND("Sand"), FISH("Fish"), ALGA("Alga"), CORAL("Coral");

        private String name;

        Type(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private Image image;
    private String path;
    private Type[] types;
    private Point[] points;
    private double[] frequency;

    public ImageInformation(Image image, String path, Type[] types, Point[] points, double[] frequency) {
        this.image = image;
        this.path = path;
        this.types = types;
        this.points = points;
        this.frequency = frequency;
    }

    public double[] getFrequency() {
        return frequency;
    }

    public Image getImage() {
        return image;
    }

    public Point[] getPoints() {
        return points;
    }

    public Type[] getTypes() {
        return types;
    }

    public String getPath() {
        return path;
    }
}
