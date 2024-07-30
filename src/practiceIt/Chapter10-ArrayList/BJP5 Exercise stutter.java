public static void stutter(ArrayList<String> array, int k){
    if(k <= 0){
    array.clear();
    }
     int size = array.size();
     for (int i = 0; i < size; i++) {
            String word = array.get(i * k);
            for (int j = 1; j < k; j++) {
                array.add(i * k + j, word);
            }
        }
}
