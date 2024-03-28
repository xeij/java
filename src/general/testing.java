package general;

import java.util.Scanner;
import java.io.*;

public class testing {

    public static void main(String[] args) throws Exception {   

        Scanner scanner = new Scanner(System.in);
        File file = new File("musicPlayList.csv");

            System.out.println("\nFile Length: " + file.length() + "\n");
            System.out.println("Absolute Path: " + file.getAbsolutePath()+ "\n");
            scanner.close();
                }

    }
