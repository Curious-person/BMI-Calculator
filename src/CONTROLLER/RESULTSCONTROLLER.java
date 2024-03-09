package CONTROLLER;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RESULTSCONTROLLER {

    @FXML
    private TextField heighttext, weighttext;

    @FXML
    private Button calculate;

    @FXML
    private Label results, calculation, calculation1;

    @FXML
    private Label resultLabel;

    @FXML
    Stage stage;

    private Scene scene;


    double height, weight;

    // EXIT & MIN BUTTONS-------------------------------------------------------------------
    public void closeWindow(ActionEvent event) {
        Platform.exit();
    }

    public void minimizeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void switchtotable(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/TABLE.fxml"));
            Parent root = loader.load();
            
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();

            System.out.println("hei hei");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        // // Constructor
        // public RESULTSCONTROLLER(Stage stage) {
        //     this.stage = stage;
        // }

    public void initData(double result) {
        // Set the received data to the label
        resultLabel.setText(String.valueOf(result));
    }

    
    public void btncalculate1(ActionEvent event) {
        try {
            height = Double.parseDouble(heighttext.getText());
            weight = Double.parseDouble(weighttext.getText());
    
            double result = calculateResult(height, weight);
            calculation.setText(Double.toString(result));
            calculation1.setText(Double.toString(result));
    
            switch (calculateCategory(result)) {
                case "Underweight":
                    results.setVisible(true);
                    results.setText("Underweight");
                    calculation.setVisible(true);
                    calculation1.setVisible(true);
                    break;
                case "Normal weight":
                    results.setVisible(true);
                    results.setText("Normal weight");
                    calculation.setVisible(true);
                    calculation1.setVisible(true);
                    break;
                case "Overweight":
                    results.setVisible(true);
                    results.setText("Overweight");
                    calculation.setVisible(true);
                    calculation1.setVisible(true);
                    break;
                case "Obese":
                    results.setVisible(true);
                    results.setText("Obese");
                    calculation.setVisible(true);
                    calculation1.setVisible(true);
                    break;
                default:
                    results.setVisible(true);
                    results.setText("Invalid input");
                    calculation.setVisible(true);
                    calculation1.setVisible(true);
                    break;
            }
    
        } catch (NumberFormatException e) {
            results.setVisible(true);
            results.setText("Please input a number");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

    private String calculateCategory(double result) {
        if (result < 18.5) {
            return "Underweight";
        } else if (result < 25.0) {
            return "Normal weight";
        } else if (result < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    private double calculateResult(double height, double weight) {
        double heightconvert = height / 100; 
        double r = (weight) / (heightconvert * heightconvert);
        r = Math.round(r * 10.0) / 10.0;
        return r;
    }


}
