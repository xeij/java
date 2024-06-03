import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintMyself {
    public static void main(String[] args) {
        String fileName = "PrintMyself.java"; 

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
