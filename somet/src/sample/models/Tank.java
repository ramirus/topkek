package sample.models;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Tank extends Node {
    private double x;
    private double y;
    private Image image;
    private String name;



    public Tank(double x, double y, Image image, String name) {
        this.x = 250;
        this.y = 250;
        this.image = image;
        this.name=name;
    }
    public String getName(){
        return name;
    }


//    private Bullet shoot() {
//        Image image = null;
//        try {
//            image = new Image(new FileInputStream("C:\\Users\\oleji\\IdeaProjects\\somet\\src\\bullet.png"), 10, 20, false, false);
//        } catch (FileNotFoundException e) {
//        }
//        Bullet bullet = new Bullet(image);
//
//        return bullet;
//    }
}
