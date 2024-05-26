public static double stdev(int[] array) {
    int sum = 0;
    
    for (int i = 0; i < array.length; i++) {
        sum += array[i];
    }
    
    double average = (double)sum / array.length;
    double top = 0;
    
    for (int i = 0; i < array.length; i++) {
        top += Math.pow(array[i] - average, 2);
    }
    
    return Math.sqrt(top / (array.length - 1));
}
