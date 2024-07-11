public static void randomLines() {
    Random random = new Random();
    int line = random.nextInt(5) + 5;
    
    for (int i = 0; i < line; i++) {
        int numOfChar = 0;
        
        while (numOfChar <= 0) {
            int letter = random.nextInt(26) + 97;
            System.out.print((char)letter);
            numOfChar++;
        }
        
        System.out.println();
    }
}
