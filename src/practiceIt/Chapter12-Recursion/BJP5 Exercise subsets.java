public static void subsets(List<String> list) {
    subsets(list, 0, list.size());
}

public static void subsets(List<String> list, int start, int end) {
    if (end == 0) {
        System.out.println(list);
    } else {
        subsets(list, start + 1, end - 1);
        String word = list.remove(start);
        subsets(list, start, end - 1);
        list.add(start, word);
    }
}
