public static boolean isPalindrome(String[] array){
	if(array.length == 0 || array.length == 1){
		return true;
	}
	int start = 0;
	int end = array.length -1;
	while (end>=start){
		if(!array[start].equals(array[end])){
			return false;
		}
		start++;
		end--;
	}
	return true;
}
