import java.util.Scanner;

public class Baek_11054_bytonic_210218 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		int[] dp = new int[N+1];
		int[] r_dp = new int[N+1];
		int[] sum = new int[N+1];
		int temp = 1;
		dp[1] = 1;
		r_dp[N] = 1;
		for(int i = 2; i<=N; i++) {
			for(int j = 1; j<i; j++) {
				if(array[i]>array[j]) {
					dp[i] = dp[i]>dp[j]?dp[i]:dp[j];
				}
			}
			dp[i]+=1;
			temp = temp>dp[i]?temp:dp[i];
		}
		for(int i = N-1; i>=1; i--) {
			for(int j = N; j>i; j--) {
				if(array[i]>array[j]) {
					r_dp[i] = r_dp[i]>r_dp[j]?r_dp[i]:r_dp[j];
				}
			}
			r_dp[i]+=1;
		}
		for(int i = 1; i<=N; i++) {
			sum[i] = dp[i]+r_dp[i]-1;
			System.out.print(sum[i]+" ");
			temp = temp>sum[i]?temp:sum[i];
		}
		System.out.println(temp);
	}

}
