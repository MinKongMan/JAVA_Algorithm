import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_20002_appleTree_220902 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		int[][] sum = new int[N+1][N+1];
		int[][] row_sum = new int[N+1][N+1];
		int[][] col_sum = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			for(int j =1 ; j<=N; j++) {
				row_sum[i][j] = row_sum[i][j-1]+array[i][j];
				col_sum[i][j] = col_sum[i-1][j]+array[i][j];
				sum[i][j] = row_sum[i][j-1] + col_sum[i-1][j] + array[i][j] + sum[i-1][j-1];
			}
		}
		
		int max = -Integer.MAX_VALUE;
		
		for(int i = 1; i<=N; i++) {
			for(int j = i; j<=N; j++) {
				for(int k = i; k<=N; k++) {
					max = Math.max(max, sum[j][k]-sum[j-i][k]-sum[j][k-i]+sum[j-i][k-i]);
				}
			}
		}
		System.out.println(max);

	}

}
