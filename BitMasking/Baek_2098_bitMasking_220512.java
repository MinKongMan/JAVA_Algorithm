import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2098_bitMasking_220512 {
	static int N,M;
	static int[][] dp, array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][(1<<(N+1))-1];
		array = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				
			}
			Arrays.fill(dp[i], 100000000);
		}
		
		System.out.println(dfs(1,1));
	}

	static int dfs(int a, int b) {
		if(b==(1<<N)-1){
			if(array[a][1]==0) {
				return 100000000;
			}
			return array[a][1];
		}
		if(dp[a][b]!=100000000) return dp[a][b];
		
		for(int i = 1; i<=N; i++) {
			if((b & (1<<i-1))==0 && array[a][i]!=0) {
				dp[a][b] = Math.min(dp[a][b], dfs(i, b|(1<<i-1))+array[a][i]);
			}
		}
		
		return dp[a][b];
	}
}
