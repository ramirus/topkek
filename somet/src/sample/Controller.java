package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import sample.models.Tank;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {
    @FXML
    private Button onePlayerBtn;

    @FXML
    private GridPane Pane;

    private List<Tank> tankList = new ArrayList<>();

    @FXML
    public void inputNameOfPlayer() throws IOException {
        Image image = new Image(new FileInputStream("C:\\Users\\oleji\\IdeaProjects\\somet\\src\\1725-i-com.supreme.tanks.jpg"));
        TextInputDialog dialog = new TextInputDialog("Петух");
        dialog.setContentText("Name:");
        Optional<String> result = dialog.showAndWait();
        String name = null;
        if (result.isPresent()) {
            name = result.get();
            battleScene();
        }
        Tank tank = new Tank(220, 300, image, name);
        tankList.add(tank);
        System.out.println(tankList.get(0).getName());

    }


    private void battleScene() throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("battle.fxml"));
        pane.setMinHeight(500);
        Pane.getChildren().setAll(pane);
        Pane.setMaxHeight(500);
    }

    @FXML
    public void initialize() {
    }
}
