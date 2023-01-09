import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_4811_medicine_231010 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[31];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i<=30; i++) {
			for(int j = 0; j<=i-1; j++) {
				dp[i] += dp[j]*dp[i-j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			sb.append(dp[N]+"\n");
		}
		System.out.println(sb);
		
		
		
		

	}

}
