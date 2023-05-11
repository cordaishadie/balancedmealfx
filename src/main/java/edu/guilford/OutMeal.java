package edu.guilford;

import java.util.Random;

/*
 * This class represents the OutMeal object, which extends the BalancedMeal object.
 * Author: Cordai Shadie
 * Course: CTIS 310
 * Final Project
 */
public class OutMeal extends BalancedMeal {
    private double price;
    private Random rand = new Random();

    /*
     * This is the default constructor for the OutMeal object.
     * It initializes the attributes to random values.
     * @param none
     * @return none
     */
    public OutMeal() {
        super();
        price = rand.nextDouble(100);
    }

    /*
     * This is the overloaded constructor for the OutMeal object.
     * It initializes the attributes to the values passed in.
     * @param mealName
     * @param vegetables
     * @param fruits
     * @param grains
     * @param protein
     * @param price
     * @return none
     */
    public OutMeal(MealName mealName, int vegetables, int fruits, int grains, int protein, double price) {
        super(mealName, vegetables, fruits, grains, protein);
        this.price = price;
    }

    // getters and setters
    /*
     * This is the getter for the price attribute.
     * @param none
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /*
     * This is the setter for the price attribute.
     * @param price
     * @return none
     */
    public void setPrice(double price) throws TimingException {
            this.price = price;
    }

    /* public void setPrice(double price) throws TimingException {
        // if the price is greater than 0 and less than 100
        if (price >= 0 && price <= 100) {
            this.price = price;
        } else {
            throw new TooMuchMoneyException("Price must be greater than 0 and less than 100!");
        }
    } */

    @Override
    /*
     * This is the toString method for the OutMeal object.
     * @param none
     * @return String
     */
    public String toString() {
        return String.format("%s, %s", super.toString(), getPrice());
    }
}
