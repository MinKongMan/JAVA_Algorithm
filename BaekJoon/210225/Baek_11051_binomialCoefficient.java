import java.util.Scanner;

public class Baek_11051_binomialCoefficient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] dp = new int[N+1][N+1];
		dp[1][0] = 1;
		dp[1][1] = 1;
		for(int i = 1; i<=N; i++) {
			dp[i][0] = 1;
			dp[0][i] = 1;
		}
		for(int i = 2; i<=N; i++) {
			for(int j = 1; j<=i; j++) {
				dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
			}
		}
		System.out.println(dp[N][M]);
	}

}
