public class average {
    public double averageMethod(int[] data){
    double sum = 0;
    for(int i=0; i<data.length; i++){
         sum += data[i];
    }
    double answer = sum/data.length;
    return answer;
    }    
}
