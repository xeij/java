public static double triangleArea(double one, double two, double three){
    double s = (one + two + three) / 2;
    return Math.sqrt(s* (s-one) * (s-two) * (s-three));
}
