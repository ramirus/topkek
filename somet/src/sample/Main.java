package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import sample.clients.ClientPlayer;

import java.util.Scanner;


public class Main extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
            primaryStage.setTitle("Tank 1990");
            Scene scene = new Scene(root, 500, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
    }


    public static void main(String[] args) {
//        ClientPlayer clientPlayer = new ClientPlayer(sc.nextLine());
//        clientPlayer.connect("127.0.0.1", 8888);
        launch(args);
//        while (true) {
//            String mes = sc.nextLine();
//            clientPlayer.sendMes(mes);
//        }
    }
}
