package Regex;

import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);

        String[] testInputs = {
                "My SSN is 123-45-6789.",
                "Invalid one: 123456789",
                "Another invalid: 12-345-6789",
                "Edge case: 000-00-0000"
        };

        for (String input : testInputs) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println("✅ \"" + matcher.group() + "\" is valid");
            } else {
                System.out.println("❌ \"" + input + "\" is invalid");
            }
        }
    }
}
