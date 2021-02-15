import java.util.Arrays;
import java.util.Scanner;

public class Baek_2293_coin_210215 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] array = new int[N+1];
		int[] dp = new int[M+1];
		dp[0] = 1;
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
			for(int j = array[i]; j<=M; j++) {
				dp[j] += dp[j-array[i]];
			}
		}
		System.out.println(dp[M]);
		
	}

}
