public static String padString(String string, int length){
    if(string.length() == length){
        return string;
    }
    else{
        int remain = length - string.length();
        String space = "";
        for(int i=0; i<remain; i++){
            space += " ";
        }
        return space + string;
    }
}
