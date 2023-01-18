import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10942_pelindrome_230118 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N+1];
		int[][] dp = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=N; i++) {
			dp[i][i] = 1;
			for(int j = 1; j<=N; j++) {
				if(i+j>N || i-j<1) break;
				if(array[i-j]==array[i+j]) {
//					System.out.println(i-j+" / "+(i+j));
					dp[i-j][i+j] = 1;
				}
				else break;
			}
			if(i+1<=N&& array[i]==array[i+1]) {
				dp[i][i+1] = 1;
				for(int j = 1; j<=N; j++) {
					if(i+j+1<=N && i-j>=1) {
						if(array[i-j]==array[i+j+1]) {
//							System.out.println(i-j+" "+(i+j));
							dp[i-j][i+j+1] = 1;
						}
						else break;
					}
				}
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				if(array[i]==array[j]) dp[i][j] = 1;
				else break;
			}
		}
		
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=N; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(dp[x][y]+"\n");
		}
		System.out.println(sb);
		
	}

}
