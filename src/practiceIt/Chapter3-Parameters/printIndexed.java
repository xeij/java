public static void printIndexed(String input) {
        StringBuilder result = new StringBuilder();
        int length = input.length();    
        for (int i = 0; i < length; i++) {
            result.append(input.charAt(i)).append(length - 1 - i);
        }
            System.out.println(result.toString());
    }
