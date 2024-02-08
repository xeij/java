import java.util.*;

public class coolAlgos {
    public static void main(String[] args) throws Exception {

        // fizzBuzz();
        // ListMethod();
        MortgageCalculator();

    }

    public static void ListMethod() {
        HashMap<Integer, Integer> banksList = new HashMap<Integer, Integer>();
        Random rand = new Random();
        System.out.println("HashMap contains: \n");
        for (int i = 0; i < 10; i++) {
            banksList.put(i, rand.nextInt(50000));
            System.out.println("Employee ID's " + i + " Account Balance $" + banksList.get(i));
        }

    }

    public static void fizzBuzz() {

        int input = 0;
        while (true) {

            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();

            if (input % 5 == 0) {
                System.out.println("Fizz");
                continue;
            }

            if (input % 3 == 0) {
                System.out.println("Buzz");
            }

            scanner.close();
        }
    }

    public static void MortgageCalculator() {

        HashMap<String, Integer> qnanswer = new HashMap<>();
        qnanswer.put("Principal: ", 5000);
        qnanswer.put("Annual Interest Rate: ", 5);
        qnanswer.put("Period (Years): ", 20);

        System.out.println(qnanswer.get(0));

        // int loanBalance =

        // Remaining balance equation : B = L[(1+c)^n - (1+c)^p] / [(1+c)^n - 1]

        // L = loan ammount
        // c = monthly interest
        // n = number of payments
        // p = number of payments made
        //
    }



}