public static void printReverse(String string){
    if(string.length() == 0){
      return;
    } else {
      for(int i=string.length() -1 ; i>=0; i--){
          System.out.print(string.charAt(i));
      }
    }
}
