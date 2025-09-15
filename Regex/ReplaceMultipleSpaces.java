package Regex;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String input = "This   is   an   example     with  multiple   spaces.";

        String output = input.replaceAll("\\s{2,}", " ");

        System.out.println("Before: " + input);
        System.out.println("After:  " + output);
    }
}
