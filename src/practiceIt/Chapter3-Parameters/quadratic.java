public static void quadratic(int a, int b, int c) {
    double squareRoot = Math.sqrt(b * b - 4 * a * c);
    double firstRoot = (-b + squareRoot) / (2 * a);
    double secondRoot = (-b - squareRoot) / (2 * a);
    System.out.println("First root = " + firstRoot);
    System.out.println("Second root = " + secondRoot);
}
