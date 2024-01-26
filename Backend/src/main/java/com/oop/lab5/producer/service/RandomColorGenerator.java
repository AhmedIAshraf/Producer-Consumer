package com.oop.lab5.producer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomColorGenerator {
    private static final List<String> colors = new ArrayList<>(List.of(
            "#0fbabd", "#ff66bc", "#6699ff", "#988abd", "#baff1e", "#ff9966", "#ccffcc", "#6060ff", "#216c5c", "#beaded",
            "#ffa375", "#c0c0c0", "#eacbda", "#e6e6fa", "#ffc1f3", "#93e9be", "#ffc1f3", "#fbddda", "#0080ff", "#000080",
            "#FF00FF", "#800080", "#008080", "#008000", "#808080", "#0fbabd", "#f0f0f0", "#f9f9f9", "#f5f5f5", "#ffcc00",
            "#aaff00", "#ff9999", "#99ff99", "#ffccff", "#ffcc99", "#99ccff", "#ccff99", "#cc99ff", "#ffcc66", "#66ccff",
            "#cc6666", "#66ffcc", "#ccccff", "#ffccff", "#ff9966", "#ff9999", "#99ff66", "#66ff99", "#9966ff", "#ccffcc",
            "#ccff66", "#fdfd96", "#f0ead6", "#fad02e", "#f8ebbb", "#f0ffe6", "#ffef96", "#e0f7fa", "#d1f0ff", "#ffefd5",
            "#eaf2f8", "#f3e7e2", "#e6f7ff", "#f8f4e6", "#fff1e1", "#f5fffd", "#fff9e6", "#f3f3f3", "#d4a5a5", "#a5d4a5",
            "#a5a5d4", "#d4d4a5", "#a5a5a5", "#e9e9e9", "#bdbdbd", "#8c8c8c", "#595959", "#2d2d2d", "#a5a5d4", "#d4a5d4",
            "#d4d4d4", "#a5d4a5", "#d4a5a5", "#a5d4d4", "#d4d4a5", "#a5a5d4", "#a5d4d4", "#d4d4d4", "#a5a5a5", "#d4a5d4",
            "#d4d4a5"
    ));

    public static String generateRandomColor() {
        // Generate random colors without repeating
        Random random = new Random();
        int color_ind = Math.abs(random.nextInt()) % colors.size();

        return colors.remove(color_ind);
    }

    public static void main(String[] args) {
        System.out.println(colors.size());
    }
}