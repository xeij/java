public static void printTriangleType(int one, int two, int three){

        if(one == two && one == three){
            System.out.print("equilateral");
        }
         else if(one == two || two == three || three == one){
            System.out.print("isosceles");
        } else 
            System.out.print("scalene");

}
