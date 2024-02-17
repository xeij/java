package leetcode;
import java.util.*;

public class lc1_twoSum {
    
    public static void main(String[] args) throws Exception {

    }
    
    public static int[] twoSum(int[] data, int target){

        Map<Integer, Integer> hash = new HashMap<Integer,Integer>();
        for(int i=0; i<=data.length; i++){
            int completion = target - data[i];
                if(hash.containsKey(completion)){
                    return new int[] {hash.get(completion), i};
            }       

                hash.put(data[i], i);
            }
        throw new IllegalArgumentException("No Match Found");
    }
}
        




