package edu.guilford;

/*
 * This class represents the TooMuchMoneyException object.
 * Author: Cordai Shadie
 * Course: CTIS 310
 * Final Project
 */

// This class is used to throw an exception when the user enters a price that is too high.
public class TooMuchMoneyException extends Exception {
    public TooMuchMoneyException(String message) {
        super(message);
    }
}
