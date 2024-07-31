public static void mirror(ArrayList<String> array){
    int size = array.size();
    for(int i=size-1; i>=0; i--){
        array.add(array.get(i));   
    }
}
