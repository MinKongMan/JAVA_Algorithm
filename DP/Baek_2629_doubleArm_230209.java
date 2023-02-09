import java.util.*;
import java.io.*;

public class Baek_2629_doubleArm_230209 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][40001];
		int[] array = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = N ; i>=1; i--) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] temp = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=M; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		char[] answer = new char[M+1];
		Arrays.fill(answer, 'N');
		
		dp[1][array[1]] = 1;
		
		for(int i = 1; i<N; i++) {
			for(int j = 40000; j>=1; j--) {
				if(dp[i][j]!=0) {
					dp[i+1][j] = dp[i][j];
					if(j+array[i+1]<=40000) dp[i+1][j+array[i+1]] = dp[i][j];
					if(j-array[i+1]>=0) dp[i+1][j-array[i+1]] = dp[i][j];
					if(array[i+1]-j>=0) dp[i+1][array[i+1]-j] = dp[i][j];
				}
				
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 0; j<=40000; j++) {
//				if(dp[i][j]>0) System.out.println(i+" "+j);
				for(int k = 1; k<=M; k++) {
					if(temp[k]==j && dp[i][j]>0) answer[k] = 'Y';
				}
			}
		}
		
		for(int i = 1; i<=M; i++) {
			System.out.print(answer[i]+" ");
		}
		
	}

}
