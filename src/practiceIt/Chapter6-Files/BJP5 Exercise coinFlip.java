public static void coinFlip(Scanner input) {
        while (input.hasNextLine()) {
            Scanner line = new Scanner(input.nextLine());
            int countH = 0; 
            int countT = 0;

            while (line.hasNext()) {
                String coin = line.next();
                if (coin.equals("H") || coin.equals("h")) {
                    countH++;
                } else if (coin.equals("T") || coin.equals("t")) {
                    countT++;
                }
            }
            double pct = (countH * 100.0) / (countH + countT);
            System.out.printf("%d heads (%.1f%%)\n", countH, pct);
            if (pct > 50) {
                System.out.println("You win!");
            }
            System.out.println();
        }
    }
