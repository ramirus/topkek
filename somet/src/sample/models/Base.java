package sample.models;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Base extends Node {
    private int x;
    private int y;
    private ImageView imageView;

    public Base(int x, int y, ImageView imageView) {
        this.x = x;
        this.y = y;
        this.imageView = imageView;
    }
}
