Scanner scanner = new Scanner(System.in);
System.out.print("Type a number (or -1 to stop): ");
int input = scanner.nextInt();
int min = input;
int max = input;
while(input != -1) {
if (input < min){
   min = input;
} else if (input > max){
   max = input;
}
System.out.print("Type a number (or -1 to stop): ");
input = scanner.nextInt();
    }
if(min != -1){
    System.out.println("Maximum was " + max);
    System.out.println("Minimum was " + min); 
}
