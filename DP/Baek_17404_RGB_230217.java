import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17404_RGB_230217 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][4];
		int[][] dp = new int[N+1][4];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			array[i][1] = x;
			array[i][2] = y;
			array[i][3] = z;
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i<=3; i++) {
			
			for(int j = 1; j<=3; j++) {
				if(i==j) dp[1][j] = array[1][j];
				else dp[1][j] = 10000000;
			}
			
			for(int j = 2; j<=N; j++) {
				dp[j][1] = Math.min(dp[j-1][2], dp[j-1][3])+array[j][1];
				dp[j][2] = Math.min(dp[j-1][1], dp[j-1][3])+array[j][2];
				dp[j][3] = Math.min(dp[j-1][2], dp[j-1][1])+array[j][3];
			}
			
			for(int j = 1; j<=3; j++) {
				if(j==i) continue;
				min = Math.min(min,dp[N][j]);
			}
		}
		System.out.println(min);
		
	}

}
