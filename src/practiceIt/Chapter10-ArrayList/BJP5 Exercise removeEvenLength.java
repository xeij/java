public static void removeEvenLength(ArrayList<String> array){

    for(int i=0; i<array.size(); i++){
        String word = array.get(i);
        if(word.length() % 2 == 0){
            array.remove(i);
            i--;
        }
    }
}
