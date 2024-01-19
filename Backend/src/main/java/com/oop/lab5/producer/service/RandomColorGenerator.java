package com.oop.lab5.producer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomColorGenerator {
    private static List<String> colors = new ArrayList<>(
            List.of("red", "yellow", "green", "cyan", "grey", "blue", "purple", "orange", "pink", "black", "violet", "indigo", "brown", "aqua")
    );
    public static String generateRandomColor() {
        // Generate random values for red, green, and blue components
        Random random = new Random();
        int color_ind = Math.abs(random.nextInt()) % colors.size();

        return colors.remove(color_ind);
    }

//    public static void main(String[] args) {
//        RandomColorGenerator r = new RandomColorGenerator();
//        System.out.println(r.generateRandomColor());
//        System.out.println(r.generateRandomColor());
//        System.out.println(r.generateRandomColor());
//        System.out.println(r.generateRandomColor());
//        System.out.println(r.generateRandomColor());
//        System.out.println(r.generateRandomColor());
//    }
}
