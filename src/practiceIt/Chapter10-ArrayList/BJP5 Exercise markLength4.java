public static void markLength4(ArrayList<String> array) {
    for (int i = 0; i < array.size(); i++) {
        if (array.get(i).length() == 4) {
            array.add(i, "****");
            i++;
        }
    }
}
