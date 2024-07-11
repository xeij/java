public static String toBinary(int num) {
    String result = "";
    result = num % 2 + result;
    num /= 2;
    while (num != 0) {
        result = num % 2 + result;
        num /= 2;
    }
    return result;}
