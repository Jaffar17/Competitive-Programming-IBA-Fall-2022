import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> out = new ArrayList<>();
        countSum(0, 0, num, out);
        Collections.sort(out);
        return out;
    }

    static void countSum(int i, int sum, int[] num, ArrayList<Integer> out){
        if(i>=num.length){
            out.add(sum);
            return;
        }
        countSum(i+1, sum+num[i], num, out);
        countSum(i+1, sum, num, out);
    }
}
