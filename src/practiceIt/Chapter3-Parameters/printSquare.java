public static void printSquare(int min, int max){
    if(min > max){
       System.out.println("Invalid parameters");
    }
    for(int i=min; i<=max; i++){
        for(int j=i; j<=max; j++){
            System.out.print(j);
        }
        for(int k=0; k< i-min; k++){
            System.out.print(min+k);
        }
        System.out.println();
    }
}
