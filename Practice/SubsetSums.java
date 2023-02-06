//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> sub = new ArrayList<Integer>();
        recCalc(0, 0, N, arr, sub);
        Collections.sort(sub);
        return sub;
    }
    void recCalc(int index, int sum, int N, ArrayList<Integer> arr, ArrayList<Integer> sub){
        if(index == N){
            sub.add(sum);
            return;
        }
        // Pick
        recCalc(index+1, sum + arr.get(index), N, arr, sub);
        // Not Pick
        recCalc(index+1, sum, N, arr, sub);
    }
}
