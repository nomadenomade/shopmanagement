package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Shop");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.resizableProperty().set(false);

        Image image = new Image(new FileInputStream(new File("C:\\Users\\guewo\\IdeaProjects\\shop_desktop\\src\\sample\\shoplogo.png")));
        primaryStage.getIcons().add(image);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
