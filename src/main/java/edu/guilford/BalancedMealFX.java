package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * This class the JavaFX Application.
 * Author: Cordai Shadie
 * Course: CTIS 310
 * Final Project
 */
public class BalancedMealFX extends Application {

    private static Scene scene;

    @Override
    /*
     * This method starts the JavaFX Application.
     * @param stage the stage
     * @throws IOException if an I/O error occurs
     */
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();

        LinkedList<BalancedMeal> balancedMeals = new LinkedList<BalancedMeal>();

        for (int i = 0; i < 10; i++) {
            balancedMeals.add(new BalancedMeal());
        }

        root.getChildren().add(new BalancedMealPane(balancedMeals));
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}