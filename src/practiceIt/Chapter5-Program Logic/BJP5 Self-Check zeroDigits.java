public static int zeroDigits(int number) {
    int count = 0;
    do {
        if (number % 10 == 0) { 
            count++;
        }
        number = number / 10;
    } while (number > 0);
    return count;
}
