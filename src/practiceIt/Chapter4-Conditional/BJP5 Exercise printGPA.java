public static void printGPA(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a student record: ");
    String name = scanner.next();
    int numberOfScores = scanner.nextInt();
    
    int sum = 0;
    for(int i=1; i<=numberOfScores; i++){
        int score = scanner.nextInt();
        sum += score;
    }
    
    double gpa = (double) sum/numberOfScores;
    System.out.println(name + "'s grade is " + gpa );
}
