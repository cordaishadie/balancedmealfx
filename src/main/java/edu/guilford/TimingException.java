package edu.guilford;

/*
 * This class represents the TimingException object.
 * Author: Cordai Shadie
 * Course: CTIS 310
 * Final Project
 */

// This class is used to throw an exception when the user enters an invalid cook time or price.
public class TimingException extends Exception {
    public TimingException(String message) {
        super(message);
    }
}
