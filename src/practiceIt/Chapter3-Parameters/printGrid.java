public static void printGrid(int row, int col) {
    for (int i = 1; i <= row; i++) { 
        int num = i;
        System.out.print(i);
        for (int j = 1; j < col; j++) {
            num += row;
            System.out.print(", " + num);
        }
        System.out.println();
    }
}
