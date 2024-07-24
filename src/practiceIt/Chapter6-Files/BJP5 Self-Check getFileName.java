public static String getFileName(){
    Scanner console = new Scanner(System.in);
    System.out.print("Type a file name: ");
    String name = console.next();
    File f = new File(name);
    
    while (!f.canRead()) {
        System.out.print("Type a file name: ");
        name = console.next();
        f = new File(name);
    }
    
    return name;
}
