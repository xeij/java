public static void smallestLargest(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("How many numbers do you want to enter? ");
    int answer = scanner.nextInt();
    System.out.print("Number 1: ");
    int answerTwo = scanner.nextInt();
    int max = answerTwo;
    int min = answerTwo;
    
    for(int i=2; i<=answer; i++){
        System.out.print("Number " + i + ": ");
        int answers = scanner.nextInt();
        if(answers < min){
           min = answers;
        } else if (answers > max) {
            max = answers;
        }
    }
    
    System.out.println("Smallest = " + min);
    System.out.println("Largest = " + max);
    
}
