Scanner console = new Scanner(System.in);

        System.out.print("Enter a card: ");
        String rankInput = console.next();
        String suitInput = console.next();

        Map<String, String> rankMap = new HashMap<>();
        rankMap.put("2", "Two");
        rankMap.put("3", "Three");
        rankMap.put("4", "Four");
        rankMap.put("5", "Five");
        rankMap.put("6", "Six");
        rankMap.put("7", "Seven");
        rankMap.put("8", "Eight");
        rankMap.put("9", "Nine");
        rankMap.put("10", "Ten");
        rankMap.put("J", "Jack");
        rankMap.put("Q", "Queen");
        rankMap.put("K", "King");
        rankMap.put("A", "Ace");

        Map<String, String> suitMap = new HashMap<>();
        suitMap.put("C", "Clubs");
        suitMap.put("D", "Diamonds");
        suitMap.put("H", "Hearts");
        suitMap.put("S", "Spades");

        String rank = rankMap.get(rankInput.toUpperCase());
        String suit = suitMap.get(suitInput.toUpperCase());

        if (rank != null && suit != null) {
            System.out.println(rank + " of " + suit);
        } else {
            System.out.println("Invalid card input");
        }
