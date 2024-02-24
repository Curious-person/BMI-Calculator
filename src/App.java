import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {


  Parent root;
try {
    root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));

    Scene scene = new Scene(root);

    primaryStage.setTitle("Information Management");
    primaryStage.setScene(scene);
    primaryStage.show();

  
} catch (IOException e) {
    System.err.println(e);
}

    }
 
 public static void main(String[] args) {
        launch(args);
    }
} 
