package edu.guilford;

import java.util.Random;

public class InMeal extends BalancedMeal {
    private double cookTime;
    private Random rand = new Random();

    public InMeal() {
        super();
        cookTime = rand.nextDouble(10, 240);
    }

    public InMeal(MealName mealName, int vegetables, int fruits, int grains, int protein, double cookTime) {
        super(mealName, vegetables, fruits, grains, protein);
        this.cookTime = cookTime;
    }

    public double getCookTime() {
        return cookTime;
    }

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
    public String toString() {
        return String.format("%s, %s", super.toString(), getCookTime());
    }
}
