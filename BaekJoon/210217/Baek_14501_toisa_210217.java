import java.util.Scanner;

public class Baek_14501_toisa_210217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array_T = new int[N+1];
		int[] dp_M = new int[N+1];
		int[] dp = new int[N+1];
		int temp = 0;
		for(int i = 1; i<=N; i++) {
			array_T[i] = sc.nextInt();
			dp_M[i] = sc.nextInt();
		}
		for(int i = 1; i<=N; i++) {
			
			if(i+array_T[i]-1<=N) {
				dp[i+array_T[i]-1]=dp[i+array_T[i]-1]>dp_M[i]+dp[i-1]?dp[i+array_T[i]-1]:dp_M[i]+dp[i-1];
				temp = temp>=dp[i]?temp:dp[i];
				dp[i] = temp;
				System.out.println(i+" "+dp[i]+" "+(i+array_T[i]-1)+" "+dp[i+array_T[i]-1]+" "+dp_M[i]+" "+temp);
				
			}
			else {
				temp = temp>=dp[i]?temp:dp[i];
				dp[i] = temp;
			}
			System.out.println(i+" "+dp[i]+" "+dp_M[i]+" "+temp);
			System.out.println();
		}
		System.out.println(temp);
		
	}

}
