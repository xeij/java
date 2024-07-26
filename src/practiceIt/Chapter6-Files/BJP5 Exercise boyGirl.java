public static void boyGirl(Scanner console) {
    int boy = 0;
    int bSum = 0;
    int girl = 0;
    int gSum = 0;
    int i = 2;
    
    while (console.hasNext()) {
        console.next();
        if ((i / 2) % 2 != 0) {
            bSum += console.nextInt();
            boy++;
        } else {
            gSum += console.nextInt();
            girl++;
        }
        i += 2;
    }
    
    System.out.println(boy + " boys, " + girl + " girls");
    System.out.println("Difference between boys' and girls' sums: " + Math.abs(bSum - gSum));
}
