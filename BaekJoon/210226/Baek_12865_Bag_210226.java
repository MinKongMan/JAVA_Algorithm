import java.util.Scanner;

public class Baek_12865_Bag_210226 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] array = new int[N+1][3];
		int[] w = new int[N+1];
		int[] v = new int[M+1];
		int[][] dp = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int a = 0;
		int y = 0;
		for(int i =1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				dp[i][j] = dp[i-1][j];
				if(j>=array[i][1]) {
					dp[i][j] = dp[i-1][j] > dp[i][j-w[i]]+v[i] ? dp[i-1][j] : dp[i][j-w[i]]+v[i];
				}
				a = dp[i][j]>a?dp[i][j]:a;
			}
		}
		System.out.println(dp[N][M]);
//		for(int i = 1; i<=N; i++) {
//			int x = 0;
//			if(array[i][1]<=M) {
//				dp[i] = array[i][2];
//				x = M-array[i][1];
//				for(int j = 1; j<i; j++) {
//					if(array[j][1]<=x) {
//						dp[i] = array[j][2]+dp[i];
//						x = x-array[j][1];
//					}
//				}
//			}
//			a = a>dp[i]?a:dp[i];
//			dp[i] = a;
//		}
	}

}
