package Regex;

import java.util.regex.*;

public class CreditCardValidator {
    public static void main(String[] args) {
        // Visa: starts with 4, total 16 digits
        String visaRegex = "^4[0-9]{15}$";

        // MasterCard: starts with 5, total 16 digits
        String masterRegex = "^5[0-9]{15}$";

        Pattern visaPattern = Pattern.compile(visaRegex);
        Pattern masterPattern = Pattern.compile(masterRegex);

        String[] testCards = {
                "4123456789012345",
                "5123456789012345",
                "6123456789012345",
                "412345678901234",
                "52234567890123456"
        };

        for (String card : testCards) {
            if (visaPattern.matcher(card).matches()) {
                System.out.println(card + " ✅ Valid Visa");
            } else if (masterPattern.matcher(card).matches()) {
                System.out.println(card + " ✅ Valid MasterCard");
            } else {
                System.out.println(card + " ❌ Invalid");
            }
        }
    }
}
