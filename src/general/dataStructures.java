//Shaya Arya

package general;

import java.io.File;
import java.util.*;

public class dataStructures { 
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void textAnimation() throws InterruptedException {

        String string = ANSI_GREEN + "Welcome to Valorant competitive gameplay, play 10 matches to earn your rank..."
                + ANSI_RESET;

        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i));
            Thread.sleep(50);
        }

    }

    public static void printLibraryContent() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Directory name: ");
        String input = scanner.nextLine();
        File f = new File(input);
        if (!f.exists()) {
            System.out.println("No such file found");
        } else {
            print(f);
            scanner.close();
        }
    }

    public static void print(File f) {
        System.out.println(f.getName());
        if (f.isDirectory()) {
            for (File subF : f.listFiles()) {
                print(subF);
            }
        }
    }

    public static char[] reverseThisHoe(String string) {

        char[] c = new char[string.length()];
        c = string.toCharArray();
        reverse(c);

        return c;

    }

    public static void reverse(char[] s) {

        // Reverse an array of Char's by using String to String.toCharArray
        // using pointahhhs

        int a_pointahhh = 0;
        int b_pointahhh = s.length - 1;

        while (a_pointahhh <= b_pointahhh) {

            char temp = s[a_pointahhh];
            s[a_pointahhh] = s[b_pointahhh];
            s[b_pointahhh] = temp;

            a_pointahhh += 1;
            b_pointahhh -= 1;

        }
    }

    public static String printStar(int n) {

        for (int y = 0; y < n; y++) {
            for (int x = 0; x <= y; x++) {

                System.out.print("*");
            }
            System.out.println();
        }
        return null;

    }

    public static Map<String, Integer> getCountwMap(Scanner in) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        while (in.hasNext()) {

            String word = in.next();
            if (map.containsKey(word)) {
                int count = map.get(word);

                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (String w : map.keySet()) {
            int count = map.get(w);
            if (count > 1) {
                System.out.println(w + " occurs " + count);
            }
        }
        return map;
    }

    public static int countUnique(List<Integer> list) {

        Set<Integer> set = new HashSet<Integer>();

        for (int i : list) {
            set.add(i);
        }

        int unique = set.size();
        return unique;
    }

    public static void algo(Map<String, String> map) {

        Map<String, String> result = new TreeMap<>();
        for (String key : map.keySet()) {

            if (key.compareTo(map.get(key)) < 0) {

                result.put(key, map.get(key));
            } else {

                result.put(map.get(key), key);
            }
        }

        System.out.println(result);

    }

    public static void findPrimes() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter max num:");
        int max = scanner.nextInt();

        List<Integer> myPrimes = algo(max);
        System.out.println(myPrimes);
        scanner.close();

    }

    public static List<Integer> algo(int max) {

        List<Integer> numbers = new LinkedList<Integer>();
        List<Integer> primes = new LinkedList<Integer>();

        for (int i = 2; i <= max; i++) {
            numbers.add(i);
        }

        while (!numbers.isEmpty()) {
            int front = numbers.remove(0);
            primes.add(front);

            Iterator<Integer> itr = numbers.iterator();
            while (itr.hasNext()) {
                int current = itr.next();
                if (current % front == 0) {
                    itr.remove();
                }
            }
        }
        return primes;
    }

    public static void insertInOrder(List<String> list, String value) {
        int index = 0;
        Iterator<String> i = list.iterator();
        String next = i.next();

        // advance until the proper index
        while (i.hasNext() && next.compareTo(value) < 0) {
            next = i.next();
            index++;
        }

        list.add(index, value);
        System.out.println(list);
    }

    public static String longest(List<String> list) {

        Iterator<String> i = list.iterator();
        String first = i.next();

        while (i.hasNext()) {

            String second = i.next();
            if (second.length() > first.length()) {

                first = second;
            }

        }

        return first;

    }

    public static void gpaAverage() {

        System.out.print("How many grades would you like to store? ");
        Scanner sc = new Scanner(System.in);
        int numberOfGrades = sc.nextInt();

        double[] grades = new double[numberOfGrades];
        double total = 0;
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Next grade? ");
            double grade = sc.nextDouble();
            grades[i] = grade;
            total += grade;
        }

        total = total / numberOfGrades;
        float sum = (float) total;
        System.out.println("The average of your grades is: " + sum);
        sc.close();
    }

    public static void rowMaker() {

        System.out.print("Enter how many rows: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int number = Integer.parseInt(input);
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            sc.close();
        }
    }

    public static void stack_push(Stack<Integer> stack)
    {
        for(int i = 0; i < 5; i++)
        {
            stack.push(i);
        }
        System.out.println(stack);
    }

    public static void pushThenSort(LinkedList<Integer> list){

        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<5;i++){
            String data = scanner.next();
            int number = Integer.parseInt(data);
            list.add(number);
        }

        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        System.out.println(list);
    }


    public static Map<Integer, Integer> countFrequency(int[] array) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < array.length; i++) {
            if (frequencyMap.containsKey(array[i])) {

                frequencyMap.put(array[i], frequencyMap.get(array[i]) + 1);
            } else {

                frequencyMap.put(array[i], 1);
            }
        }
        
        return frequencyMap;
    }

     /*
     
        // Call the method to count frequency
        Map<Integer, Integer> frequencyMap = countFrequency(array);

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Element: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
   
        */

        public static void findPairClosestToZero(int[] arr) {
        
            if (arr == null || arr.length < 2) {
            System.out.println("Array needs to have at least two elements.");
            return;
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = arr.length - 1;
        
        int closestSum = Integer.MAX_VALUE;
        int closestPairLeft = left;
        int closestPairRight = right;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                closestPairLeft = left;
                closestPairRight = right;
            }
            
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                
                break;
            }
        }
        
        System.out.println("The pair whose sum is closest to zero is: (" 
                            + arr[closestPairLeft] + ", " + arr[closestPairRight] + ")");
    }


    public static void main(String[] args) throws Exception {

        //textAnimation();
        //Stack<Integer> stack = new Stack<Integer>();
        //stack_push(stack);

        LinkedList<Integer> list = new LinkedList<Integer>();
        pushThenSort(list);
    }

}
