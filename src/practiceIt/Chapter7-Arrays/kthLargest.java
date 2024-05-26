public static int kthLargest(int k, int[] array){
sort(array);
int answer = array[array.length] - k;
return answer;
}

private static void sort(int[] array){
	boolean swapped = true;
	int j=0;
	int temp;
	while(swapped){
		swapped = false;
		j++;
		for(int i=0; i < array.length; i++){
				if(array[i] > array[i+1]){
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swapped = true;
				}
		}
	}
}
