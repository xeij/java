public static void flipLines(Scanner input) {
    while (input.hasNextLine()) {
        String line = input.nextLine();
        if (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
        System.out.println(line);
    }
}
