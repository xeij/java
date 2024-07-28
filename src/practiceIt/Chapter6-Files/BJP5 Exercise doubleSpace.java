public static void doubleSpace(Scanner input, PrintStream output) {
    while (input.hasNextLine()) {
        output.println(input.nextLine());
        output.println();
    }
}
