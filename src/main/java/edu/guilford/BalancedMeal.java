package edu.guilford;

import java.util.Random;

/*
 * This class represents the BalancedMeal object.
 * Author: Cordai Shadie
 * Course: CTIS 310
 * Final Project
 */
public class BalancedMeal implements Comparable<BalancedMeal> {
    // attributes
    protected MealName mealName;
    protected int vegetables;
    protected int fruits;
    protected int grains;
    protected int protein;
    private Random rand = new Random();

    /*
     * This is the default constructor for the BalancedMeal object.
     * It initializes the attributes to random values.
     * @param none
     * @return none
     */
    public BalancedMeal() {
        mealName = new MealName();
        vegetables = rand.nextInt(20);
        fruits = rand.nextInt(12);
        grains = rand.nextInt(8);
        protein = rand.nextInt(6);
    }

    /*
     * This is the overloaded constructor for the BalancedMeal object.
     * It initializes the attributes to the values passed in.
     * @param mealName
     * @param vegetables
     * @param fruits
     * @param grains
     * @param protein
     * @return none
     */
    public BalancedMeal(MealName mealName, int vegetables, int fruits, int grains, int protein) {
        this.mealName = new MealName();
        this.vegetables = vegetables;
        this.fruits = fruits;
        this.grains = grains;
        this.protein = protein;
    }

    // getters and setters
    /*
     * This is the getter for the mealName attribute.
     * @param none
     * @return mealName
     */
    public MealName getMealName() {
        return mealName;
    }

    /*
     * This is the setter for the mealName attribute.
     * @param mealName
     * @return none
     */
    public void setMealName(MealName mealName) {
        this.mealName = mealName;
    }

    /*
     * This is the getter for the vegetables attribute.
     * @param none
     * @return vegetables
     */
    public int getVegetables() {
        return vegetables;
    }

    /*
     * This is the setter for the vegetables attribute.
     * @param none
     * @return none
     */
    public void setVegetables(int vegetables) {
        this.vegetables = vegetables;
    }

    /*
     * This is the getter for the fruits attribute.
     * @param none
     * @return fruits
     */
    public int getFruits() {
        return fruits;
    }

    /*
     * This is the setter for the fruits attribute.
     * @param fruits
     * @return none
     */
    public void setFruits(int fruits) {
        this.fruits = fruits;
    }

    /*
     * This is the getter for the grains attribute.
     * @param none
     * @return grains
     */
    public int getGrains() {
        return grains;
    }

    /*
     * This is the setter for the grains attribute.
     * @param grains
     * @return none
     */
    public void setGrains(int grains) {
        this.grains = grains;
    }

    /*
     * This is the getter for the protein attribute.
     * @param none
     * @return protein
     */
    public int getProtein() {
        return protein;
    }

    /*
     * This is the setter for the protein attribute.
     * @param protein
     * @return none
     */
    public void setProtein(int protein) {
        this.protein = protein;
    }

    // toString method
    @Override
    /*
     * This is the toString method for the BalancedMeal object.
     * It returns a string representation of the object.
     * @param none
     * @return string representation of the object
     */
    public String toString() {
        return "BalancedMeal{" +
                "mealName= '" + mealName + '\'' +
                ", vegetables= " + vegetables +
                ", fruits= " + fruits +
                ", grains= " + grains +
                ", protein= " + protein +
                '}' + "\n";
    }

    // compareTo method
    @Override
    /*
     * This is the compareTo method for the BalancedMeal object.
     * It compares the mealName attribute of the object to the mealName attribute of the object passed in.
     * @param o
     * @return string representation of the object
     */
    public int compareTo(BalancedMeal o) {
        // return a string representation of the object
        return mealName.compareTo(o.mealName);

    }
    
    /*
     * This is the healthScore method for the BalancedMeal object.
     * It calculates the health score of the object.
     * @param none
     * @return score
     */
    public double healthScore() {
        double score = 0.0;
        if ((vegetables / 20) >= 1) {
            score += 20;
        } else if ((vegetables / 20) >= 0.75) {
            score += 15;
        } else if ((vegetables / 20) >= 0.5) {
            score += 10;
        } else  if ((vegetables / 20) >= 0.25) {
            score += 5;
        }
        if ((fruits / 12) >= 1) {
            score += 20;
        } else if ((fruits / 12) >= 0.75) {
            score += 15;
        } else if ((fruits / 12) >= 0.5) {
            score += 10;
        } else  if ((fruits / 12) >= 0.25) {
            score += 5;
        }

        if ((grains / 8) >= 1) {
            score += 20;
        } else if ((grains / 8) >= 0.75) {
            score += 15;
        } else if ((grains / 8) >= 0.5) {
            score += 10;
        } else  if ((grains / 8) >= 0.25) {
            score += 5;
        }

        if ((protein / 6) >= 1) {
            score += 20;
        } else if ((protein / 6) >= 0.75) {
                score += 15;
        } else if ((protein / 6) >= 0.5) {
                    score += 10;
        } else  if ((protein / 6) >= 0.25) {
            score += 5;
        }
        
        return score;
    }
}

