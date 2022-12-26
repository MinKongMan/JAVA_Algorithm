import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_13398_prefix2_221227 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] array = new int[N+1];
        int[][] dp = new int[3][N+1];
        
        st = new StringTokenizer(br.readLine());
        dp[1][0] = -5000;
        dp[2][0] = -5000;
        for(int i = 1; i<=N; i++) {
        	dp[1][i] = -5000;
        	dp[2][i] = -5000;
        	array[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for(int i = 1; i<=N; i++) {
        	dp[1][i] = Math.max(dp[1][i-1]+array[i], array[i]);
        	dp[2][i] = Math.max(dp[2][i-1]+array[i], dp[1][i-1]);
        }
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i<=N; i++) {
        	max = Math.max(max, dp[1][i]);
        	max = Math.max(max, dp[2][i]);
        }
        System.out.println(max);

	}

}
