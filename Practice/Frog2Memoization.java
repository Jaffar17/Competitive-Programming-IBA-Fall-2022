import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Frog2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] stones = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            stones[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(stones));
        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);
        frogJump(N-1, K, stones, dp);
        output.write(dp[N-1]);
        output.flush();
    }

    static int frogJump(int N, int K, int[] stones, int[] dp){
        if(N==0){
            return 0;
        }
        if(dp[N]!=-1){
            return dp[N];
        }
        int steps = Integer.MAX_VALUE;
        for(int i=1; i<=K; i++){
            if((N-i)>=0){
                int jump = frogJump(N-i, K, stones, dp) + Math.abs(stones[N] - stones[N-i]);
                steps = Math.min(steps, jump);
            }
        }
        dp[N] = steps;
        return dp[N];
    }
}
