import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11066_fileFusion_210315 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int i = 1; i<=TC; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] array = new int[N+1];
			int[] sum = new int[N+1];
			int[][] dp = new int[N+1][N+1];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 1; j<=N; j++) {
				sum[j] += sum[j-1]+array[j];
			}
			
			for(int j = 1; j<N; j++) {
				for(int k = 1; k<=N-j; k++) {
					dp[k][k+j] = Integer.MAX_VALUE;
					for(int x = k; x<k+j; x++) {
						dp[k][k+j] = Math.min(dp[k][k+j], dp[k][x]+dp[x+1][k+j]);
					}
					dp[k][k+j] += sum[k+j]-sum[k-1];
				}
			}
			sb.append(dp[1][N]+"\n");
		}
		System.out.print(sb);
	}

}
