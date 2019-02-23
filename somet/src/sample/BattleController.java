package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import sample.models.Bullet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BattleController {
    @FXML
    private Button startGame;
    @FXML
    private AnchorPane Pane;
    @FXML
    private Node base;
    @FXML
    private Node tank;


    private boolean up, down, left, right;

    private int speed = 5;
    
    @FXML
    public void handle() {
        Scene scene = Pane.getScene();
        List<Bullet> bulletList = new ArrayList<>();
        Pane.getChildren().remove(startGame);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (KeyCode.W == event.getCode()) {
                tank.setRotate(0);
                if (tank.getLayoutY() >= -10) {
                    tank.setLayoutY(tank.getLayoutY() - speed);
                    up = true;
                    System.out.println(Pane.getHeight());
                    System.out.println(tank.getLayoutY());
                } else {
                    return;
                }
            }
            if (KeyCode.S == event.getCode()) {
                tank.setLayoutY(tank.getLayoutY() + speed);
                tank.setRotate(180);
                down = true;
            }
            if (KeyCode.A == event.getCode()) {
                tank.setLayoutX(tank.getLayoutX() - speed);
                tank.setRotate(270);
                left = true;
            }
            if (KeyCode.D == event.getCode()) {
                tank.setLayoutX(tank.getLayoutX() + speed);
                tank.setRotate(90);
                right = true;
            }
            if (KeyCode.SPACE == event.getCode()) {
                Image image = null;
                try {
                    image = new Image(new FileInputStream("C:\\Users\\oleji\\IdeaProjects\\somet\\src\\bullet.png"), 10, 20, false, false);
                    Bullet bullet = new Bullet(image);
                    if (tank.getRotate() == 0) {
                        bullet.setLayoutX(tank.getLayoutX() + 20);
                        bullet.setLayoutY(tank.getLayoutY() - 12);
                    }
                    if (tank.getRotate() == 180) {
                        bullet.setLayoutX(tank.getLayoutX() + 20);
                        bullet.setLayoutY(tank.getLayoutY() + 40);
                    }
                    if (tank.getRotate() == 270) {
                        bullet.setLayoutX(tank.getLayoutX() - 10);
                        bullet.setLayoutY(tank.getLayoutY() + 15);
                    }
                    if (tank.getRotate() == 90) {
                        bullet.setLayoutX(tank.getLayoutX() + 50);
                        bullet.setLayoutY(tank.getLayoutY() + 15);
                    }
                    bullet.setRotate(tank.getRotate());
                    bulletList.add(bullet);
                    Pane.getChildren().add(bullet);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            if (KeyCode.W == event.getCode()) {
                up = false;
            }

            if (KeyCode.S == event.getCode()) {
                down = false;
            }

            if (KeyCode.A == event.getCode()) {
                left = false;
            }

            if (KeyCode.D == event.getCode()) {
                right = false;
            }
        });

    }

    @FXML
    public void initialize() {

    }
}
