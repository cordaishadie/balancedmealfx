package edu.guilford;

/*
 * This class represents a meal name.
 * Author: Cordai Shadie
 * Course: CTIS 310
 * Final Project
 */
public class MealName implements Comparable<MealName> {
    // attributes
    private String mainDish;
    private String sideDish;

    enum SortOrder{FORWARD, REVERSE}
    public static SortOrder sortOrder = SortOrder.FORWARD;

    // constructors
    /*
     * This is the default constructor for the MealName object.
     * It initializes the attributes to random values.
     * @param none
     * @return none
     */
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

    /*
     * This is the overloaded constructor for the MealName object.
     * It initializes the attributes to the values passed in.
     * @param mainDish
     * @param sideDish
     * @return none
     */
    public MealName(String mainDish, String sideDish) {
        this.mainDish = mainDish;
        this.sideDish = sideDish;
    }

    // getters and setters
    /*
     * This is the getter for the mainDish attribute.
     * @param none
     * @return mainDish
     */
    public String getMainDish() {
        return mainDish;
    }

    /*
     * This is the setter for the mainDish attribute.
     * @param mainDish
     * @return none
     */
    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }

    /*
     * This is the getter for the sideDish attribute.
     * @param none
     * @return sideDish
     */
    public String getSideDish() {
        return sideDish;
    }

    /*
     * This is the setter for the sideDish attribute.
     * @param sideDish
     * @return none
     */
    public void setSideDish(String sideDish) {
        this.sideDish = sideDish;
    }

    // toString method
    /*
     * This is the toString method for the MealName object.
     * @param none
     * @return String
     */
    @Override
    public String toString() {
        return mainDish + " with " + sideDish;
    }

    // compareTo method
    @Override
    /*
     * This is the compareTo method for the MealName object.
     * @param other
     * @return int
     */
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
