import java.util.Scanner;

public class Baek_1904_01Tyle_210302 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i<=N; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
