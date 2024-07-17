
public static boolean hasMidpoint(int a, int b, int c) {
    if (a == b && b == c && a == c) {
        return true;
    } else {
        int smallest = Math.min(a, Math.min(b, c));
        int largest = Math.max(a, Math.max(b, c));
        double midpoint = (smallest + largest) / 2.0;
        
        if (midpoint != smallest) {
            if (midpoint == a || midpoint == b || midpoint == c) {
                return true;
            } else {
                return false;
            }
        }
        
        return false;
    }
}
