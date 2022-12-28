import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2602_stoneBridge_221228 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        
        int N = s.length();
        
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int[][][] answer = new int[3][N+1][str1.length()+1];
        
        int[][][] dp = new int[3][N+1][str1.length()+1];
        
        for(int i = 1; i<=str1.length(); i++) {
        	char a1 = str1.charAt(i-1);
        	char b1 = str2.charAt(i-1);
        	
        	for(int j = 1; j<=N; j++) {
        		char c1 = s.charAt(j-1);
//        		System.out.print(i+" : "+dp[1][j][i]+" "+dp[2][j][i]+" / ");
        		if(c1==a1) {
        			if(j==1) {
        				dp[1][j][i]++;
        				dp[1][j][i] += dp[1][j][i-1];
        			}
        			else {
	        			dp[1][j][i] = dp[2][j-1][i-1];
	        			dp[1][j][i] += dp[1][j][i-1];
        			}
        		}
        		else {
        			dp[1][j][i] += dp[1][j][i-1];
        		}
        		
        		if(c1==b1) {
        			if(j==1) {
        				dp[2][j][i]++;
        				dp[2][j][i] += dp[2][j][i-1];
        			}
//        			dp[2][j][i] += dp[2][j][i-1]+dp[1][j-1][i-1];
        			else {
        			dp[2][j][i] = dp[1][j-1][i-1];
        			dp[2][j][i] += dp[2][j][i-1];
        			}
        		}
        		else {
        			dp[2][j][i] += dp[2][j][i-1];
        		}
//        		System.out.println(dp[1][j][i]+" "+dp[2][j][i]);
        	}
        }
        
        System.out.println(dp[1][N][str1.length()]+dp[2][N][str2.length()]);
    }

}
