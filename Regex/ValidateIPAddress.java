package Regex;

import java.util.regex.*;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"
                + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        Pattern pattern = Pattern.compile(regex);

        String[] testIPs = {
                "192.168.0.1",
                "255.255.255.255",
                "256.100.50.25",
                "192.168.1",
                "123.045.067.089"
        };

        for (String ip : testIPs) {
            Matcher matcher = pattern.matcher(ip);
            if (matcher.matches()) {
                System.out.println(ip + " ✅ Valid");
            } else {
                System.out.println(ip + " ❌ Invalid");
            }
        }
    }
}
