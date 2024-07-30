public static void removeDuplicates(ArrayList<String> array) {

    for (int i = 0; i < array.size() - 1; i++) {
        if (array.get(i).equals(array.get(i + 1))) {
            array.remove(i + 1);
            i--;
        }
    }
    
}
