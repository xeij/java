System.out.print("How many numbers? ");
Scanner scanner = new Scanner(System.in);
int numbers = scanner.nextInt();
int product = 1;
for(int i=1; i<=numbers; i++){
    System.out.print("Next number --> ");
    int input = scanner.nextInt();
    product *= input;
}

System.out.println("Product = " + product);
