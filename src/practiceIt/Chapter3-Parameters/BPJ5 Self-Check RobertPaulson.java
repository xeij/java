Scanner scanner = new Scanner(System.in);
System.out.print("What is your phrase? ");
String input = scanner.nextLine();
System.out.print("How many times should I repeat it? ");
int repeat = scanner.nextInt();
for(int i=0;i<repeat; i++){
System.out.println(input);
    }
