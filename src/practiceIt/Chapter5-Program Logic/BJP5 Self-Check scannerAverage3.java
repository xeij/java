Scanner scanner = new Scanner(System.in);
double sum = 0.0;
for(int i=0; i<3; i++){
    System.out.print("Type an integer: ");
    while(!scanner.hasNextInt()){
        scanner.next();
        System.out.print("Type an integer: ");
    }
    sum += scanner.nextInt();
}
System.out.println("Average: " + sum/3);
