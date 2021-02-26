import java.util.Arrays;
import java.util.Scanner;

public class Baek_2294_coin2_210226 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] array = new int[N+1];
		int[] dp = new int[M+1];
		dp[array[1]] = 1;
		Arrays.fill(dp, 100000);
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		for(int i = 1; i<=M; i++) {
			for(int j = 1; j<=N; j++) {
				dp[array[j]]=1;
			}
			for(int j = 1; j<i; j++) {
				dp[i] = dp[i]<dp[i-j]+dp[j]?dp[i]:dp[i-j]+dp[j];
			}
		}
		System.out.println(dp[M]==100000?-1:dp[M]);
	}

}
