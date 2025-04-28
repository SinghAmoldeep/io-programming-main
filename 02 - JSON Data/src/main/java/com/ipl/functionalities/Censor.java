package com.ipl.functionalities;

public class Censor {
    public static String apply(String input) {
        String[] words = input.split(" ");
        if (words.length == 0) return "***";

        words[words.length - 1] = "***";
        return String.join(" ", words);

        // return input.replaceAll("(\\b\\w+)$", "***");  // with regex
    }

    public static String redacted(String input) {
        return "REDACTED";
    }
}
