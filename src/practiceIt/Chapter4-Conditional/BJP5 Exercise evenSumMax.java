public static void evenSum(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("how many integers? ");
    int input = scanner.nextInt();
    int sum = 0;
    int max = 0;
    
    for(int i=1; i<=input; i++){
        System.out.print("next integer? ");
        int nextInput = scanner.nextInt();
        if(nextInput % 2 == 0){
            sum += nextInput;
        }
        if(nextInput % 2 == 0){
            if(nextInput > max){
                max = nextInput;
            }
        }
    }
    
    System.out.println("even sum = " + sum);
    System.out.println("even max = " + max);
    
}
