package com.oop.lab5.producer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomColorGenerator {
    private static List<String> colors = new ArrayList<>(
            List.of("#0fbabd", "#ff66bc", "#6699ff", "#988abd", "#baff1e", "#ff9966", "#ccffcc", "#6060ff", "#216c5c", "#0fbabd",
                    "#beaded", "#ffa375", "#c0c0c0", "#eacbda", "#e6e6fa", "#ffc1f3", "#93e9be", "#ffc1f3", "#fbddda", "#0080ff",
                    "#000080", "#FF00FF", "#800080", "#008080", "#008000", "#808080")
    );
    public static String generateRandomColor() {
        // Generate random colors without repeating
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
