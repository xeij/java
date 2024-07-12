public void makeGuesses() {
    Random random = new Random();
    int guess;
    int count = 0;
    
    do {
        guess = random.nextInt(50) + 1;
        System.out.println("guess = " + guess);
        count++;
    } while (guess < 48);
    
    System.out.println("total guesses = " + count);
}
