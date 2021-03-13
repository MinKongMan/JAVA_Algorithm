import java.util.Scanner;

public class Baek_1915_bigSquare_210313 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = 0;
		int[][] array = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			String k = sc.next();
			for(int j = 1; j<=M; j++) {
				array[i][j] = k.charAt(j-1)-'0';
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array[i][j]==1) {
					dp[i][j] = 1;
					if(dp[i-1][j-1]!=0) {
						int a = (int)Math.sqrt(dp[i-1][j-1]);
						int b = 0;
						int c = 0;
						boolean mark = true, mark2 = true;
						for(int k = i; k>=i-a; k--) {
							if(array[k][j]==1) {
								b++;
							}
							else {
								break;
							}
						}
						for(int k = j; k>=j-a; k--) {
							if(array[i][k]==1) {
								c++;
							}
							else break;
						}
						b = b<c?b:c;
						dp[i][j] = b*b;
					}
				}
				System.out.print(dp[i][j]+" ");
				max = max>dp[i][j]?max:dp[i][j];
			}
			System.out.println();
		}
		System.out.println(max);
		
		
	}
}
