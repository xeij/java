public static void xo(int x) {
		int a = 0;
		int z = x - 1;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < x; j++) {
				if(j == a || j == z) {
				System.out.print("x");
				} else {
			System.out.print("o");
			}
			}
			System.out.println();
			a++;
			z--;
		}
	}
