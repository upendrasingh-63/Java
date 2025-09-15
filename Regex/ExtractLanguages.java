package Regex;

import java.util.regex.*;
import java.util.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        String[] languages = { "Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "PHP", "Swift",
                "Kotlin" };

        String regex = "\\b(" + String.join("|", languages) + ")\\b";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> found = new ArrayList<>();
        while (matcher.find()) {
            found.add(matcher.group());
        }

        System.out.println("Extracted Languages: " + String.join(", ", found));
    }
}
