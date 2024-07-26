public static void evenNumbers(Scanner console) {
    int totalNum = 0;
    int sum = 0;
    int evenNum = 0;
    
    while (console.hasNextInt()) {
        int num = console.nextInt();
        totalNum++;
        sum += num;
        if (num % 2 == 0) {
            evenNum++;
        }
    }
    
    System.out.printf("%d numbers, sum = %d\n", totalNum, sum);
    System.out.printf("%d evens (%.2f%%)\n", evenNum, 100.0 * evenNum / totalNum);
}
