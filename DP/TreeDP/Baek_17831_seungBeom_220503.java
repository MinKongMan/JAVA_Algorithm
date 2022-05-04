import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_17831_seungBeom_220503 {
	static ArrayList<Integer>[] ar;
	static int[] array;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		ar = new ArrayList[N+1];
		array = new int[N+1];
		dp = new int[3][N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i= 2; i<=N; i++) {
			ar[Integer.parseInt(st.nextToken())].add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1);
		System.out.println(Math.max(dp[1][1], dp[2][1]));
	}
	
	static void dfs(int x) {
		for(int a : ar[x]) {
			dfs(a);
			dp[2][x] += Math.max(dp[1][a], dp[2][a]);
		}
		dp[1][x] = dp[2][x];
		for(int a : ar[x]) {
			dp[1][x] = Math.max(dp[1][x], dp[2][x]-Math.max(dp[1][a], dp[2][a])+array[a]*array[x]+dp[2][a]);
			
		}
	}

}
