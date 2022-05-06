import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_10835_card_220506 {
	static int[] array_l,array_r;
	static int[][] dp;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		dp = new int[N+2][N+2];
		array_l = new int[N+1];
		array_r = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			array_l[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			array_r[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<=N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int val = 0;
		
		System.out.println(top_down(1,1));

	}
	
	static int top_down(int x, int y) {
		if(x==N+1 || y == N+1) return 0;
		
		if(dp[x][y]!=-1) return dp[x][y];
		dp[x][y] = 0;
		
		int answer1 = top_down(x+1,y);
		int answer2 = top_down(x+1,y+1);
		
		int answer3 = 0;
		if(array_l[x]>array_r[y])  answer3 = array_r[y]+top_down(x,y+1);
			
			
		return dp[x][y] = Math.max(answer1, Math.max(answer2, answer3));
	}

}
