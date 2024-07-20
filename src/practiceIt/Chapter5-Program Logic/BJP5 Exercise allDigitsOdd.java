public static boolean allDigitsOdd(int num) {
    boolean result = true;
    num = Math.abs(num);
    if (num == 0) {
        result = false;
    }
    
    while (num != 0) {
        int digit = num % 10;
        if (digit % 2 == 0) {
            result = false;
        }
        num /= 10;
    }
    
    return result;
}
