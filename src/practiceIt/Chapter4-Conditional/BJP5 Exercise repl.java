public static String repl(String string, int num){
    StringBuilder str = new StringBuilder();
    for(int i=1; i<=num; i++){
        str.append(string);
    }
    return str.toString();
}
