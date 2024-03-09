package CONTROLLER;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TABLECONTROLLER {

    private Scene scene;
    private Stage stage;

        public void backbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/VIEW/RESULTS.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }
}
