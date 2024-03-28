package general
import java.util.Scanner;

public class piglatin {
    
    public static String pigLatin(String word) {
        String vowels = "aeiouAEIOU";
        if (vowels.contains(String.valueOf(word.charAt(0)))) {
            return word + "ay";
        } else {
            return word.substring(1) + word.charAt(0) + "ay";
        }
    }
    
    public static String convertToPigLatin(String sentence) {
        StringBuilder pigLatinSentence = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            pigLatinSentence.append(pigLatin(word)).append(" ");
        }
        return pigLatinSentence.toString().trim();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Pig Latin Converter!");
        while (true) {
            System.out.print("Enter a sentence (or type 'quit' to exit): ");
            String sentence = scanner.nextLine();
            if (sentence.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                String pigLatinSentence = convertToPigLatin(sentence);
                System.out.println("Pig Latin: " + pigLatinSentence);
            }
        }
        scanner.close();
    }
}
