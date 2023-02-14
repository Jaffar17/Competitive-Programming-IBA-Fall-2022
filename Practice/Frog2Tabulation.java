import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Frog2Tabulation {
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
        dp[0] = 0;

        for(int i=1; i<N; i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1; j<=K; j++){
                if((i-j) >= 0){
                    int jump = dp[i-j] + Math.abs(stones[i] - stones[i-j]);
                    minSteps = Math.min(jump, minSteps);
                }
                // maybe here
                dp[i] = minSteps;
            }
            //dp[i] = minSteps;
        }
        System.out.println(dp[N-1]);
//        output.write(dp[N-1]);
//        output.flush();
    }
}
