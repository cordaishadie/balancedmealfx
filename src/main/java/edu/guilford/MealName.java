package edu.guilford;

public class MealName implements Comparable<MealName> {
    // attributes
    private String mainDish;
    private String sideDish;

    enum SortOrder{FORWARD, REVERSE}
    public static SortOrder sortOrder = SortOrder.FORWARD;

    public MealName() {
        // choose a random main dish from a list of 20 possibilities
        String[] mainDishes = { "Chipotle Bowl", "Burrito", "Taco", "Pizza", "Pasta", "Burger", "Salad", "Soup",
                "Sandwich", "Stir Fry", "Curry", "Rice Bowl", "Sushi", "Chicken", "Steak", "Pork", "Fish", "Shrimp",
                "Eggs", "Omelette" };
        int randomIndex = (int) (Math.random() * mainDishes.length);
        mainDish = mainDishes[randomIndex];

        // choose a random side dish from a list of 20 possibilities
        String[] sideDishes = { "Chips", "Fries", "Rice", "Beans", "Potatoes", "Bread", "Noodles", "Soup", "Salad",
                "Fruit", "Vegetables", "Eggs", "Omelette", "Toast", "Biscuit", "Muffin", "Pancakes", "Waffles",
                "Yogurt", "Cheese" };
        randomIndex = (int) (Math.random() * sideDishes.length);
        sideDish = sideDishes[randomIndex];
    }

    public MealName(String mainDish, String sideDish) {
        this.mainDish = mainDish;
        this.sideDish = sideDish;
    }

    // getters and setters
    public String getMainDish() {
        return mainDish;
    }

    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }

    public String getSideDish() {
        return sideDish;
    }

    public void setSideDish(String sideDish) {
        this.sideDish = sideDish;
    }

    // toString method
    @Override
    public String toString() {
        return mainDish + " with " + sideDish;
    }

    // compareTo method
    @Override
    public int compareTo(MealName other) {
        int result = mainDish.compareTo(other.mainDish);
        if (result == 0) {
            result = sideDish.compareTo(other.sideDish);
        }
        if (sortOrder == SortOrder.REVERSE) {
            result = -result;
        }
        return result;
    }

}
