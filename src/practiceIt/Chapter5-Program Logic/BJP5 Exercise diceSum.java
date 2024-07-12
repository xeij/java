public void diceSum() {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    
    System.out.print("Desired dice sum: ");
    int desiredSum = scanner.nextInt();
    
    int dice1, dice2, sum;
    
    do {
        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;
        sum = dice1 + dice2;
        System.out.println(dice1 + " and " + dice2 + " = " + sum);
    } while (sum != desiredSum);
}
