public static void printRange(int one, int two){
    if(one < two){
    for(int i=one; i<=two; i++){
        System.out.print(i + " ");
        }
    } else if (one > two) {
        for(int i=one; i>=two; i--){
        System.out.print(i + " ");
        }
    } else {
        System.out.println(one);
    }
    System.out.println();
}
