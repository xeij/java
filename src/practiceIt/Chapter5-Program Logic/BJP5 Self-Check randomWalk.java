public static void randomWalk(){
    int position = 0;
    int maxPosition = 0;
    Random rand = new Random();
    System.out.println("position = " + position);
    
    while(position != 3 && position != -3){
        int step = rand.nextInt(2);
         if (step == 0) {
             position++;
         } else {
             position--;
    }
        
    System.out.println("position = " + position);
            if (position > maxPosition) {
            maxPosition = position;
        }
    }
    
    System.out.println("max position = " + maxPosition);
}
