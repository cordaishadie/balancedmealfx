package edu.guilford;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.util.LinkedList;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BalancedMealPane extends GridPane {
    private LinkedList<BalancedMeal> balancedMeals;
    private BalancedMeal balancedMeal;

    // keeop track of the current balanced meal
    private int currentBalancedMeal = 0;

    private Label mealNameLabel;
    private Label vegetablesLabel;
    private Label fruitsLabel;
    private Label grainsLabel;
    private Label proteinLabel;

    private TextField mealNameTextField;
    private TextField vegetablesTextField;
    private TextField fruitsTextField;
    private TextField grainsTextField;
    private TextField proteinTextField;

    private Button calculateButton;
    private Label healthLabel;

    private ImageView imageView;
    private Label ratingLabel;
    private Slider ratingSlider;
    private Button increaseRating;
    private Button decreaseRating;

    private ComboBox mealTypeComboBox;
    private Label cookTimeLabel;
    private TextField cookTimeTextField;
    private Label priceLabel;
    private TextField priceTextField;

    private Button previousButton;
    private Button nextButton;

    public BalancedMealPane(LinkedList<BalancedMeal> balancedMeals) {
        // everything in the BalancedMealPane is going to in this constructor
        this.balancedMeals = balancedMeals;

        // instantiate the labels
        BalancedMeal balancedMeal = this.balancedMeals.get(currentBalancedMeal);
        mealNameLabel = new Label("Meal Name: " + balancedMeal.getMealName());
        vegetablesLabel = new Label("Vegetables: " + balancedMeal.getVegetables());
        fruitsLabel = new Label("Fruits: " + balancedMeal.getFruits());
        grainsLabel = new Label("Grains: " + balancedMeal.getGrains());
        proteinLabel = new Label("Protein: " + balancedMeal.getProtein());

        // instantiate the text fields
        mealNameTextField = new TextField();
        vegetablesTextField = new TextField();
        fruitsTextField = new TextField();
        grainsTextField = new TextField();
        proteinTextField = new TextField();

        // instantiate the button
        calculateButton = new Button("Eat meal!");
        // instantiate the healthiness label
        healthLabel = new Label("Healthiness: " + balancedMeal.healthScore());

        // instantiate the combo box with the choices "Eating Out" and "Eating In"
        mealTypeComboBox = new ComboBox();
        mealTypeComboBox.getItems().addAll("Ate In", "Ate Out");
        mealTypeComboBox.setValue("Did you eat in or out?");

        // instantiate the image view
        File rateFace = new File(this.getClass().getResource("Shadie_Yummy_Bitmoji.png").getPath());
        // instantiate the image view
        imageView = new ImageView(rateFace.toURI().toString());
        // change the size of the image
        imageView.setFitHeight(200);
        // and keep the aspect ratio
        imageView.setPreserveRatio(true);

        // instantiate the rating label
        ratingLabel = new Label("What would you rate you meal?");
        // instantiate the rating slider
        ratingSlider = new Slider(0, 10, 5);
        // instantiate the increase rating button
        increaseRating = new Button("(+) rating");
        // instantiate the decrease rating button
        decreaseRating = new Button("(-) rating");

        // instantiate the cook time label
        cookTimeLabel = new Label("How long did it take to cook?");
        // instantiate the cook time text field
        cookTimeTextField = new TextField();

        // instantiate the price label
        priceLabel = new Label("How much did it cost?");
        // instantiate the price text field
        priceTextField = new TextField();

        // instantiate the previous and next buttons
        previousButton = new Button("Previous");
        nextButton = new Button("Next");
        previousButton.setDisable(true);
        nextButton.setDisable(false);    

        /* separation between instantiating and adding */

        // add the labels and text fields to the pane
        add(new Label(), 0, 0);
        add(mealNameLabel, 0, 1);
        add(vegetablesLabel, 0, 2);
        add(fruitsLabel, 0, 3);
        add(grainsLabel, 0, 4);
        add(proteinLabel, 0, 5);
        add(healthLabel, 0, 6);

        add(mealNameTextField, 1, 1);
        add(vegetablesTextField, 1, 2);
        add(fruitsTextField, 1, 3);
        add(grainsTextField, 1, 4);
        add(proteinTextField, 1, 5);

        // add the button to the pane
        add(calculateButton, 1, 7);
        add(previousButton, 0, 7);
        add(nextButton, 2, 7);

        add(new Label(), 0, 8);
        // add the combo box to the pane
        add(mealTypeComboBox, 0, 9);

        add(cookTimeLabel, 0, 10);
        cookTimeLabel.setVisible(false);
        add(cookTimeTextField, 1, 10);
        cookTimeTextField.setVisible(false);

        add(priceLabel, 0, 10);
        priceLabel.setVisible(false);
        add(priceTextField, 1, 10);
        priceTextField.setVisible(false);
        
        // add the label and slider to the pane
        add(new Label(), 0, 12);
        add(ratingLabel, 0, 13);
        add(decreaseRating, 0, 14);
        add(ratingSlider, 1, 14);
        add(increaseRating, 2, 14);
        add(imageView, 0, 15);


        /* separation between adding and event handling */

        // add an event handler to the button
        calculateButton.setOnAction(event -> {
            try {
            setLabels();
            } catch (BlankTextException e) {
                healthLabel.setStyle("-fx-text-fill: red");
                healthLabel.setText("Please fill in all the text fields!");
            } catch (NumberFormatException e) {
                healthLabel.setStyle("-fx-text-fill: red");
                healthLabel.setText("Please enter a number for the component text fields!");

            BalancedMeal newBalancedMeal = new BalancedMeal(balancedMealNameField(), Integer.parseInt(vegetablesTextField.getText()), 
                Integer.parseInt(fruitsTextField.getText()), Integer.parseInt(grainsTextField.getText()), 
                Integer.parseInt(proteinTextField.getText()));    
            
            this.balancedMeals.add(newBalancedMeal);

            currentBalancedMeal = this.balancedMeals.size() - 1;

            mealNameLabel.setText("Meal Name: " + newBalancedMeal.getMealName());
            vegetablesLabel.setText("Vegetables: " + newBalancedMeal.getVegetables());
            fruitsLabel.setText("Fruits: " + newBalancedMeal.getFruits());
            grainsLabel.setText("Grains: " + newBalancedMeal.getGrains());
            proteinLabel.setText("Protein: " + newBalancedMeal.getProtein());
                
            }
            
        });

        // add an event listener for the increase rating button
        increaseRating.setOnAction(e -> {
            ratingSlider.setValue(ratingSlider.getValue() + 1);
            imageView.setFitHeight(ratingSlider.getValue() * 40);
        });

        // add an event listener for the decrease rating button
        decreaseRating.setOnAction(e -> {
            ratingSlider.setValue(ratingSlider.getValue() - 1);
            imageView.setFitHeight(ratingSlider.getValue() * 40);
        });
        
        // add an event listener for the slider
        ratingSlider.setOnMouseReleased(e -> {
            imageView.setFitHeight(ratingSlider.getValue() * 40);
        });
        
        // add an event listener for the combo box
        mealTypeComboBox.setOnAction(e -> {
            if (mealTypeComboBox.getValue().equals("Ate In")) {
                cookTimeLabel.setVisible(true);
                cookTimeTextField.setVisible(true);
                priceLabel.setVisible(false);
                priceTextField.setVisible(false);
            } else if (mealTypeComboBox.getValue().equals("Ate Out")) {
                priceLabel.setVisible(true);
                priceTextField.setVisible(true);
                cookTimeLabel.setVisible(false);
                cookTimeTextField.setVisible(false);
            }
        });
         
        // add an event listener that works for both the previous and next buttons
        EventHandler<ActionEvent> changeBalancedMeal = e -> {
            Button source = (Button) e.getSource();
            if (source == nextButton) {
                currentBalancedMeal++;
                if (currentBalancedMeal >= this.balancedMeals.size()) {
                    nextButton.setDisable(true);
                    currentBalancedMeal = this.balancedMeals.size() - 1;
                }
            } else { 
                currentBalancedMeal--;
                if (currentBalancedMeal < 0) {
                    previousButton.setDisable(true);
                    currentBalancedMeal = 0;
                }
            }
            nextButton.setDisable(currentBalancedMeal >= this.balancedMeals.size() - 1);
            previousButton.setDisable(currentBalancedMeal < 1);
            // update the labels
            BalancedMeal bm = this.balancedMeals.get(currentBalancedMeal);
            mealNameLabel.setText("Meal Name: " + bm.getMealName());
            vegetablesLabel.setText("Vegetables: " + bm.getVegetables());
            fruitsLabel.setText("Fruits: " + bm.getFruits());
            grainsLabel.setText("Grains: " + bm.getGrains());
            proteinLabel.setText("Protein: " + bm.getProtein());

            // update the text fields
            mealNameTextField.setText(bm.getMealName().toString());
            vegetablesTextField.setText(Integer.toString(bm.getVegetables()));
            fruitsTextField.setText(Integer.toString(bm.getFruits()));
            grainsTextField.setText(Integer.toString(bm.getGrains()));
            proteinTextField.setText(Integer.toString(bm.getProtein()));
            healthLabel.setText("Health: " + bm.healthScore());
        };

        // add the event listeners to the buttons
        previousButton.setOnAction(changeBalancedMeal);
        nextButton.setOnAction(changeBalancedMeal);
    }

    // this is where I'll create exceptions and extra methods

    public static class BlankTextException extends Exception {
        public BlankTextException(String message) {
            super("Blank Text Exception");
        }
    }

    public static class FontSizeException extends Exception {
        public FontSizeException(String message, Throwable err) {
            super("Font Size Exception", err);
        }
    }

    public static class TooManyCharactersException extends Exception {
        public TooManyCharactersException(String message, Throwable err) {
            super("Too Many Characters Exception", err);
        }
    }

    public void setLabels() throws BlankTextException {
        // if any of the text fields are blank, throw a BlankTextException
        if (mealNameTextField.getText().equals("") || vegetablesTextField.getText().equals("")
                || fruitsTextField.getText().equals("") || grainsTextField.getText().equals("")
                || proteinTextField.getText().equals("")) {
            throw new BlankTextException("Blank Text Exception");
        } else {
            // set the labels to the text in the text fields
            mealNameLabel.setText("Meal Name: " + mealNameTextField.getText());
            vegetablesLabel.setText("Vegetables: " + vegetablesTextField.getText());
            fruitsLabel.setText("Fruits: " + fruitsTextField.getText());
            grainsLabel.setText("Grains: " + grainsTextField.getText());
            proteinLabel.setText("Protein: " + proteinTextField.getText());
            
            BalancedMeal bm = this.balancedMeals.get(currentBalancedMeal); // create a new balanced meal
            bm.setFruits(Integer.parseInt(fruitsTextField.getText())); // set the fruits, grains, protein, and vegetables
            bm.setGrains(Integer.parseInt(grainsTextField.getText())); // to the text in the text fields
            bm.setProtein(Integer.parseInt(proteinTextField.getText())); 
            bm.setVegetables(Integer.parseInt(vegetablesTextField.getText()));
            healthLabel.setText("Healthiness: " + bm.healthScore());
            this.balancedMeals.add(bm);
            System.out.println(balancedMeals);
        }
    }

    private MealName balancedMealNameField() {
        String mealName = mealNameTextField.getText();
        return new MealName();
    }
}