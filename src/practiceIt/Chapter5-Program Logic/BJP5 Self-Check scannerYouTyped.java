Scanner scanner = new Scanner(System.in);
System.out.print("Type a number: ");
if (scanner.hasNextInt()){
System.out.println("You typed the integer " + scanner.nextInt());
} else {
System.out.println("You typed the real number " + scanner.nextDouble());
}
