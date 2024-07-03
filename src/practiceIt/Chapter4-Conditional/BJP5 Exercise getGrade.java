public static double getGrade(int point) {
		if(point < 0 || point > 100) {
			throw new IllegalArgumentException();
			
		} else if(point < 60) {
			return 0.0;
		} else if(point >= 60 && point < 62) {
			return 0.7;
		} else if(point >= 63 && point < 95) {
			double p = .0;
				p+= .8 + (point - 63) * .1;
			return p;
		} else if(point >= 95 && point <= 100) {
			return 4.0;
		} else {
			return 0;
		}
	}
