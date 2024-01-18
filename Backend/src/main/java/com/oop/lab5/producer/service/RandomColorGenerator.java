package com.oop.lab5.producer.service;

import java.awt.*;

public class RandomColorGenerator {
//    public static void main(String[] args) {
//        // Generate a random color
//        Color randomColor = generateRandomColor();
//
//        // Convert the color to a string in RGB format
//        String colorString = convertColorToString(randomColor);
//
//        // Print the result
//        System.out.println("Random Color: " + colorString);
//    }

    public static Color generateRandomColor() {
        // Generate random values for red, green, and blue components
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);

        // Create a Color object with the random values
        return new Color(red, green, blue);
    }

    public static String convertColorToString(Color color) {
        // Convert the RGB components to a string in the format "(R, G, B)"
        return "(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")";
    }
}
