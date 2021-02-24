import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baek_9251_LCS_210224 {
	public static void main(String[] args) {
		String a,b;
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int[][] dp;
		a = sc.nextLine();
		b = sc.nextLine();
		dp = new int[a.length()+1][b.length()+1];
		for(int i = 1; i<=a.length(); i++) {
			for(int j = 1; j<=b.length(); j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
				}
				System.out.print(dp[i][j]+" ");
				count = count>dp[i][j]?count:dp[i][j];
			}
			System.out.println();
		}
		
		System.out.println(count);
	}

}
