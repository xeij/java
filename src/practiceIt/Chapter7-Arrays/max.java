public class max {
    public int max(int array[]){
        int temp = array[0];
        for(int i=0;i<array.length; i++){
            if(array[i] > temp){
                temp = array[i];
            }

        }
        return temp;
   } 
}
