public static int maxLength (ArrayList<String> list) {
    if (list == null || list.size() == 0){
        return 0;
    }
    
    int max = list.get(0).length();
    for (int i = 1; i <=list.size()-1; i++) {
        if (max <= list.get(i).length()){
            max = list.get(i).length();
        }
    }
    return max;
}
