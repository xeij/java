public static int mode(int[] array) {
		int[] spareArray = new int[101];
		for (int i = 0; i < array.length; i++) {
	        spareArray[array[i]]++;
	    }
		int mode = 101;
	    int count = 0;
	    for (int i = 0; i < spareArray.length; i++) {
	        if (spareArray[i] > count) {
	            count = spareArray[i];
	            mode = i;
	        }
	    }
	    
	    return mode;
	}
