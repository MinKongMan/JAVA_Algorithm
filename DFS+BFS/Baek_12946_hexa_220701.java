import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12946_hexa_220701 {
	static int[][] array;
	static int[] dx = {0,-1,-1}, dy = {-1,0,1};
	static int[][] dp;
	static boolean[][] marked;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		marked = new boolean[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=N; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				if(l.charAt(j-1)=='X') array[i][j] = 1;
			}
		}
		
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(array[i][j]==1 && !marked[i][j]) {
					marked[i][j] = true;
					dfs(i,j);
				}
			}
		}
		
		int max = 0;
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(array[i][j] == 0) {
					System.out.print(0+" ");
					continue;
				}
				System.out.print(dp[i][j]+" ");
				max = Math.max(dp[i][j], max);
			}
			System.out.println();
		}
		System.out.println(max);
		
	}
	
	static void dfs(int x, int y) {
		boolean[] check = new boolean[4];
		System.out.println(x+" "+y);
		for(int i = 0; i<3; i++) {
			int temp_x = x+dx[i];
			int temp_y = y+dy[i];
			
			if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
			if(array[temp_x][temp_y]==0) continue;
			if(dp[temp_x][temp_y]==Integer.MAX_VALUE) continue;
			check[dp[temp_x][temp_y]] = true;
		}
		for(int i = 1; i<=3; i++) {
			if(!check[i]) {
				dp[x][y] = i;
				break;
			}
		}
		
		if(y+1<=N && array[x][y+1]==1) {
			marked[x][y+1] = true;
			dfs(x,y+1);
		}
	}

}
