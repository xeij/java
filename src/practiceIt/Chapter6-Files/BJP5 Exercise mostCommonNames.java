public static int mostCommonNames (Scanner input) {
    int uniqueNames = 0;
    
    while (input.hasNextLine()) {
        Scanner line = new Scanner(input.nextLine());
        uniqueNames++;
        String refName = line.next(); 
        String mostName = refName; 
        int count = 1; 
        int countMax = 1; 
        
        while (line.hasNext()) {
            String name2 = line.next();
            if (name2.equals(refName)) {
                count++; 
                if (countMax < count) { 
                    countMax = count; 
                    mostName = name2; 
                }
                
            } else {
                refName = name2; 
                uniqueNames++;
            }                               
        }        
        System.out.println("Most common: " + mostName);                
    }
    return uniqueNames;

}
