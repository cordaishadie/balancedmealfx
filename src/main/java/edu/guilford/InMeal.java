package edu.guilford;

import java.util.Random;

/*
 * This class represents the InMeal object, which extends the BalancedMeal object.
 * Author: Cordai Shadie
 * Course: CTIS 310
 * Final Project
 */
public class InMeal extends BalancedMeal {
    private double cookTime;
    private Random rand = new Random();

    /*
     * This is the default constructor for the InMeal object.
     * It initializes the attributes to random values.
     * @param none
     * @return none
     */
    public InMeal() {
        super();
        cookTime = rand.nextDouble(10, 240);
    }

    /*
     * This is the overloaded constructor for the InMeal object.
     * It initializes the attributes to the values passed in.
     * @param mealName
     * @param vegetables
     * @param fruits
     * @param grains
     * @param protein
     * @param cookTime
     * @return none
     */
    public InMeal(MealName mealName, int vegetables, int fruits, int grains, int protein, double cookTime) {
        super(mealName, vegetables, fruits, grains, protein);
        this.cookTime = cookTime;
    }

    // getters and setters
    /*
     * This is the getter for the cookTime attribute.
     * @param none
     * @return cookTime
     */
    public double getCookTime() {
        return cookTime;
    }

    /*
     * This is the setter for the cookTime attribute.
     * @param cookTime
     * @return none
     */
    public void setCookTime(double cookTime) throws TimingException {
            this.cookTime = cookTime;
    }

    /* public void setCookTime(double cookTime) throws TimingException {
        // if the cook time is greater than 15 minutes and less than 240 minutes
        if (cookTime >= 15 && cookTime <= 240) {
            this.cookTime = cookTime;
        } else {
            throw new TimingException("Cook time must be greater than 15 minutes and less than 240 minutes!");
        }
    } */
    
    @Override
    /*
     * This is the compareTo method for the InMeal object.
     * It compares the cookTime attribute of two InMeal objects.
     * @param inMeal
     * @return int
     */
    public String toString() {
        return String.format("%s, %s", super.toString(), getCookTime());
    }
}
