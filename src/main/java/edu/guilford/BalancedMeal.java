package edu.guilford;

import java.util.Random;

public class BalancedMeal implements Comparable<BalancedMeal> {
    // attributes
    protected MealName mealName;
    protected int vegetables;
    protected int fruits;
    protected int grains;
    protected int protein;
    private Random rand = new Random();

    public BalancedMeal() {
        mealName = new MealName();
        vegetables = rand.nextInt(20);
        fruits = rand.nextInt(12);
        grains = rand.nextInt(8);
        protein = rand.nextInt(6);
    }

    public BalancedMeal(MealName mealName, int vegetables, int fruits, int grains, int protein) {
        this.mealName = new MealName();
        this.vegetables = vegetables;
        this.fruits = fruits;
        this.grains = grains;
        this.protein = protein;
    }

    // getters and setters
    public MealName getMealName() {
        return mealName;
    }

    public void setMealName(MealName mealName) {
        this.mealName = mealName;
    }

    public int getVegetables() {
        return vegetables;
    }

    public void setVegetables(int vegetables) {
        this.vegetables = vegetables;
    }

    public int getFruits() {
        return fruits;
    }

    public void setFruits(int fruits) {
        this.fruits = fruits;
    }

    public int getGrains() {
        return grains;
    }

    public void setGrains(int grains) {
        this.grains = grains;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    // toString method
    @Override
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
    public int compareTo(BalancedMeal o) {
        // return a string representation of the object
        return mealName.compareTo(o.mealName);

    }

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

