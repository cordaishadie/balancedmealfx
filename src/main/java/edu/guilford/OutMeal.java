package edu.guilford;

import java.util.Random;

public class OutMeal extends BalancedMeal {
    private double price;
    private Random rand = new Random();

    public OutMeal() {
        super();
        price = rand.nextDouble(100);
    }

    public OutMeal(MealName mealName, int vegetables, int fruits, int grains, int protein, double price) {
        super(mealName, vegetables, fruits, grains, protein);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

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
    public String toString() {
        return String.format("%s, %s", super.toString(), getPrice());
    }
}
