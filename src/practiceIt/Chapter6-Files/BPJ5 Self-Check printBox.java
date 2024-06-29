public static void printBox(Scanner input, int width) {
    printTopBottom(width); 
    while (input.hasNextLine()) {
        String line = input.nextLine();
        System.out.print("| " + line);
        for (int i = line.length(); i < width; i++) { 
            System.out.print(" ");
        }
        System.out.println(" |");
    }
    printTopBottom(width);
}

public static void printTopBottom(int width) {
    System.out.print("+");
    for (int i = 0; i < width + 2; i++) {
        System.out.print("-");
    }
    System.out.println("+");
}
