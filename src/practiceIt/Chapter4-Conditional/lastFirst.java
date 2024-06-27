public static String lastFirst(String name) {
		String[] parts = name.split(" ");
		return parts[1] + ", " + parts[0].charAt(0) + ".";
	}
