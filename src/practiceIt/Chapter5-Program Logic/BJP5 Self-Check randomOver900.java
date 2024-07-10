Random random = new Random();
        int number;
        do {
            number = random.nextInt(1000);
            System.out.println("Random number: " + number);
        } while (number < 900);
