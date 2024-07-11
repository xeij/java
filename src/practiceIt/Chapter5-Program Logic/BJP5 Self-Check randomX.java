public static void randomX() {
  Random rand = new Random();
  int num = 5 + rand.nextInt(15);

  while (true) { 
    for (int i = 0; i < num; i++) {
        System.out.print("x");
    }
    if (num > 16) { 
        break;
    } else {
       System.out.println();
    }
    num = 5 + rand.nextInt(15);
    }
}
