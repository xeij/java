public static int digitSum(int num) {
    num = Math.abs(num);
    int sum = 0;
    
    while (num != 0) {
        sum += num % 10;
        num /= 10;
    }
    
    return sum;
}
