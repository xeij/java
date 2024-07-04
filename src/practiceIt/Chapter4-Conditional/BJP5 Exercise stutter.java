public static String stutter(String string){
    StringBuilder stutter = new StringBuilder();
    for(int i=0; i<string.length(); i++){
        stutter.append(string.charAt(i));
        stutter.append(string.charAt(i));
    }
    return stutter.toString();
}
