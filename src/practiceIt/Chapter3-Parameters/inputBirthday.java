public static void inputBirthday(Scanner scanner){
    System.out.print("On what day of the month were you born? ");
    int input = scanner.nextInt();
    System.out.print("What is the name of the month in which you were born? ");
    String input2 = scanner.next();
    System.out.print("During what year were you born? ");
    int input3 = scanner.nextInt();
    System.out.println("You were born on " + input2 + " " + input + ", " + input3 + ". You're mighty old!");
}
