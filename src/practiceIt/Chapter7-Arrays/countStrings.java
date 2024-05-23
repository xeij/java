public int countStrings(String[] array, String target){
	int answer = 0;
	for(int i=0; i<array.length; i++){
		if(array[i] == target){
			answer++;
		}
	}
	return answer;
}
