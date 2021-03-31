import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2631_lineMake_210401 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = 0;
		int[] array = new int[N+1];
		int[] dp = new int[N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			array[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<i; j++) {
				if(array[i]>array[j]) {
					dp[i] = dp[i]>dp[j]?dp[i]:dp[j];
				}
			}
			dp[i] = dp[i]+1;
			k = k>dp[i]?k:dp[i];
		}
		System.out.println(N-k);
	}

}
