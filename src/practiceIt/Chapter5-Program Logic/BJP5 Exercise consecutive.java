public static boolean consecutive(int a, int b, int c) {
    if (a == b || b == c || a == c) {
        return false;
    } else {
        int smallest = Math.min(a, Math.min(b, c));
        int largest = Math.max(a, Math.max(b, c));
        return largest - smallest == 2;
    }
}
