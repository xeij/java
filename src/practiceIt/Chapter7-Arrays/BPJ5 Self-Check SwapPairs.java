public static void swapPairs(String[] s){
	for(int i=0; i < s.length / 2; i++){
		String temp = s[2*i];
		s[2*i] = s[2*i+1];
		s[2*i+1] = temp;
	}
	System.out.println(Arrays.toString(s));
}
