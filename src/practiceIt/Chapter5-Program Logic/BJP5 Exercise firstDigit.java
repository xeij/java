public static int firstDigit(int num) {
    num = Math.abs(num);
    
    while (num / 10 != 0) {
        num /= 10;
    }
    
    return num;
}
