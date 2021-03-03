import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11048_moving_210303 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] k = br.readLine().split(" ");
		int N = Integer.parseInt(k[0]);
		int M = Integer.parseInt(k[1]);
		int[][] array = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][1] = array[1][1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				int a = dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
				a = a>dp[i-1][j-1]?a:dp[i-1][j-1];
				dp[i][j] = a+array[i][j];
			}
		}
		System.out.println(dp[N][M]);
	}

}
