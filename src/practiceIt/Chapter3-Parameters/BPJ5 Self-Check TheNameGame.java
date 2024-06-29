public class TheNameGame{

public static void algo(Scanner console){
    System.out.print("What is your name? ");
    String first = console.next();
    String last = console.next();
    String suffix = first.substring(1);
    System.out.println(first + " " + first + ", bo-B" + suffix);
    System.out.println("Banana-fana fo-F" + suffix);
    System.out.println("Fee-fi-mo-M" + suffix);
    System.out.println(first.toUpperCase() + "!");
    
    String suffix2 = last.substring(1);
    System.out.println();
    System.out.println(last + " " + last + ", bo-B" + suffix2);
    System.out.println("Banana-fana fo-F" + suffix2);
    System.out.println("Fee-fi-mo-M" + suffix2);
    System.out.println(last.toUpperCase() + "!");
    
    }

public static void main(String args[]){
    Scanner scanner = new Scanner(System.in);
    algo(scanner);
    }
}
