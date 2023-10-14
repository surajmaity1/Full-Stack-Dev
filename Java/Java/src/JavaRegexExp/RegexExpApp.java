package JavaRegexExp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Check valid IPV4
        String originalText = "255.198.192.27";
        String regex =
                "((\\d|\\d\\d|[0-1]\\d\\d|2[0-4][0-9]|25[0-5])\\.){3}(\\d|\\d\\d|[0-1]\\d\\d|2[0-4][0-9]|25[0-5])";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(originalText);

        boolean result = matcher.matches();

        System.out.println((result) ? "Valid": "Not Valid");

        scanner.close();
    }
}
