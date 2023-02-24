import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11058_kri_230224 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		
		long[] dp = new long[105];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for(int i = 1; i<=N; i++) {
			dp[i] = Math.max(i, dp[i]);
			int count = 2;
//			System.out.println(dp[i]);
			for(int j = i+3; j<=N; j++) {
				dp[j] = Math.max(j, dp[j]);
				dp[j] = Math.max(dp[j], dp[i]*count);
//				System.out.println(j+" "+dp[j]);
				count++;
			}
		}
		
		System.out.println(dp[N]);
	}

}
