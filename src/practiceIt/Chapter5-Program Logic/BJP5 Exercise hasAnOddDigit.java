public static boolean hasAnOddDigit(int num) {
    if (num == 0) {
        return false;
    } else {
        num = Math.abs(num);
        
        while (num != 0) {
            int digit = num % 10;
            if (digit % 2 != 0) {
                return true;
            }
            num /= 10;
        }
        
        return false;
    }
}
