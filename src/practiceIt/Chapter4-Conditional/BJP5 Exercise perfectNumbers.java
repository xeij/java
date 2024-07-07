public static void perfectNumbers(int max) {
    String numbers = "";
    for (int i = 1; i <= max; i++) {
        int sum = 0;
        for (int j = 1; j < i; j++) {
            if (i % j == 0) {
                sum += j;
            }
        }
        if (sum == i) {
            numbers += i + " ";
        }
    }
    System.out.println("Perfect numbers up to " + max + ": " + numbers);
}
