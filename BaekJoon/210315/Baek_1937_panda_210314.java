import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1937_panda_210314 {
	static int[][] array,dp;
	static boolean[][] marked;
	static int N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int count = 0, max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		marked = new boolean[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=  1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(marked[i][j]==false) {
					count = 0;
					DFS(i,j);
					max = max>dp[i][j]?max:dp[i][j];
				}
//				System.out.print(dp[i][j]+" ");
			}
//			System.out.println();
		}
		System.out.println(max);
		
	}
	static void DFS(int a, int b) {
		marked[a][b] = true;
		for(int i = 0; i<4; i++) {
			int temp_x = a+dx[i];
			int temp_y = b+dy[i];
			if(temp_x<1 || temp_x>N || temp_y<1 || temp_y>N) continue;
			if(marked[temp_x][temp_y] && array[a][b]<array[temp_x][temp_y]) {
				dp[a][b] = dp[a][b]>dp[temp_x][temp_y]?dp[a][b]:dp[temp_x][temp_y];
			}
			else if(array[a][b]<array[temp_x][temp_y] && !marked[temp_x][temp_y]) {
				DFS(temp_x,temp_y);
				dp[a][b] = dp[a][b]>dp[temp_x][temp_y]?dp[a][b]:dp[temp_x][temp_y];
			}
		}
		dp[a][b]++;
	}
}
