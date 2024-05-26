public int kthLargest(int k, int[] array){
boolean swapped = true;
int j=0;
int temp;
while(swapped){
	swapped = false;
	j++;
	for(int i=0; i < array.length-j-1; i++){
			if(array[i] > array[i+1]){
				temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				swapped = true;
			}
	}
}
int answer = array[array.length - (k+1)];
return answer;
}
