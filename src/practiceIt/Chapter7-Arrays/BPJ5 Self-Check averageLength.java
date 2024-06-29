public double averageLength(String[] array){
	double words = 0;
	double size = array.length;
	int i;
		for(i=0; i<size; i++){
			words += array[i].length();
		}
		return words/size;
}
