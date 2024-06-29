public static int secondHalfLetters(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(Character.toLowerCase(s.charAt(i)) >= 'n') {
				count++;
			}
		}
			return count;
}
