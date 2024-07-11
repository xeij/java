public static boolean isVowel(String c) {
    if(c.isEmpty()){
    return false;}
    return "aeiouAEIOU".indexOf(c) >= 0;
}
