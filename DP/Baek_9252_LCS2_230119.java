import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_9252_LCS2_230119 {
	static int[][] dp;
	static String[][] answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		answer = new String[a.length()+1][b.length()+1];
		dp = new int[a.length()+1][b.length()+1];
		
		for(int i = 1; i<=a.length(); i++) {
			for(int j = 1; j<=b.length(); j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					if(dp[i-1][j]>dp[i][j-1]) {
						dp[i][j] = dp[i-1][j];
					}
					else {
						dp[i][j] = dp[i][j-1];
					}
				}
			}
		}
		
		if(dp[a.length()][b.length()]==0) {
			System.out.println(0);
			return;
		}
		
		int x = a.length();
		int y = b.length();
//		for(int i = 1; i<=x; i++) {
//			for(int j = 1; j<=y; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		String l = "";
		while(true) {
			if(x==0 || y==0) break;
			if(dp[x][y]==dp[x-1][y]) x--; 
			else if(dp[x][y]==dp[x][y-1]) y--;
			else {
				l = a.charAt(x-1)+l;
				x--;
				y--;
			}
		}
		System.out.println(dp[a.length()][b.length()]);
		System.out.println(l);
	}
}
