public static boolean equals(String[] a, String[] b){
	if(a.length == b.length){
		if(Arrays.equals(a,b)){
			return true;
		}
	}
	return false;
}	
