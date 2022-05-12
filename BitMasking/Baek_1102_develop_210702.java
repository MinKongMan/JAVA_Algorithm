import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1102_develop_210702 {
	static class find implements Comparable<find>{
		int start;
		int end;
		int val;
		find(int start, int end, int val){
			this.start = start;
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(find o) {
			// TODO Auto-generated method stub
			return this.val-o.val;
		}
		
	}
	static int INF = 100000000, N;
	static int[][] array, dp;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
	
		dp = new int[N+1][(1<<N)];
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				int a = Integer.parseInt(st.nextToken());
				array[i][j] = a;
			}
			Arrays.fill(dp[i], INF);
		}
		
		String l = br.readLine();
		
		int bit = 0;
		int on = 0;
		for(int i = 0; i<l.length(); i++) {
			bit = (bit<<1);
			if(l.charAt(i)=='Y'){
				on++;
				bit++;
			}
		}
		
		count = Integer.parseInt(br.readLine());
		int x = dfs(on,bit);
		if(on==0 && count == 0) {
			System.out.println(0);
			return;
		}
		else if(on==0) {
			System.out.println(-1);
			return;
		}
		System.out.println(x!=INF?x:-1);
	}
	
	static int dfs(int start, int bit) {
		if(start>=count) return 0;
		if(dp[start][bit]!=INF) return dp[start][bit];
		
		for(int i = N; i>=1; i--) {
			if((bit & 1<<(i-1)) == 1<<(i-1)){
				for(int j = N; j>=1; j--) {
					if(i==j || (bit & 1<<(j-1))==1<<(j-1)) continue;
					else {
//						System.out.println(i+" "+j+" ÀÌ°Ô?");
						dp[start][bit] = Math.min(dp[start][bit], dfs(start+1,bit | 1<<(j-1))+array[N-i+1][N-j+1]);
					}
				}
			}
		}
//		System.out.println(start+" "+bit);
//		System.out.println(dp[start][bit]);
		return dp[start][bit];
	}

}
