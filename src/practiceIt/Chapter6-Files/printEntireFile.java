public static void printEntireFile() throws FileNotFoundException{
        System.out.print("Type a file name: ");
	Scanner scanner = new Scanner(System.in);
	String input = scanner.next();
	Scanner output = new Scanner(new File(input));
	
	while(output.hasNextLine()){
		System.out.println(output.nextLine());
	}
}
