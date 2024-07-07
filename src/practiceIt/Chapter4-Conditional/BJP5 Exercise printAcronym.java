public static void printAcronym(String string){
    String answer= "";
    answer += string.charAt(0);
    for(int i=0; i< string.length(); i++){
        if(string.charAt(i) == ' '){
            answer += string.charAt(i + 1);
        }
    }
    System.out.println(answer);
}
