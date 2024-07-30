public static void doubleList(ArrayList<String> array){

    for(int i=0; i< array.size(); i++){
        String word = array.get(i);
        array.add(i+1, word);
        i++;
    }
}
