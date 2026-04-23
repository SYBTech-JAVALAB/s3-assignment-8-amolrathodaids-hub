import java.util.Scanner;

public class ReviewAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter the customer review for analysis:");
        String review = scanner.nextLine();

        // Edge case: check if input is empty
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Error: Review is empty. Please enter valid text.");
            scanner.close();
            return;
        }

        // 1. Character Count (includes spaces and punctuation)
        int charCount = review.length();

        // 2. Word Count
        // .trim() removes leading/trailing spaces, .split("\\s+") splits by any number of spaces
        String[] words = review.trim().split("\\s+");
        int wordCount = words.length;

        // 3. Normalized Text
        String upperCaseText = review.toUpperCase();
        String lowerCaseText = review.toLowerCase();

        // 4. Reversed Text
        // Using StringBuilder as it has a built-in reverse method which is highly efficient
        StringBuilder sb = new StringBuilder(review);
        String reversedText = sb.reverse().toString();

        // 5. Palindrome Flag
        // To accurately check sentences, we remove spaces/punctuation and ignore case
        String cleanString = review.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String cleanReversed = new StringBuilder(cleanString).reverse().toString();
        boolean isPalindrome = cleanString.equals(cleanReversed) && !cleanString.isEmpty();

        // --- Output Results ---
        System.out.println("\n=========================================");
        System.out.println("       REVIEW ANALYSIS INSIGHTS      ");
        System.out.println("=========================================");
        System.out.println("Original Review : " + review);
        System.out.println("Character Count : " + charCount);
        System.out.println("Word Count      : " + wordCount);
        System.out.println("Normalized (UP) : " + upperCaseText);
        System.out.println("Normalized (low): " + lowerCaseText);
        System.out.println("Reversed Text   : " + reversedText);
        System.out.println("Is Palindrome?  : " + (isPalindrome ? "Yes (Flag: True)" : "No (Flag: False)"));
        System.out.println("=========================================");

        scanner.close();
    }
}