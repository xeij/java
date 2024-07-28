public static String readEntireFile(Scanner input) {
    String output = "";
    
    while (input.hasNextLine()) {
        output += input.nextLine() + "\n";
    }
    
    return output;
}
