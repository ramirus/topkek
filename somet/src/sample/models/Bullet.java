package sample.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet extends ImageView {
     private int speed=10;

    public int getSpeed() {
        return speed;
    }


    public Bullet(Image image) {
        super(image);
        this.speed = speed;
    }

    public void breakWall() {

    }
}
