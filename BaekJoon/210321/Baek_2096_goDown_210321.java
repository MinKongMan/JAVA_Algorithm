import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2096_goDown_210321 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp1,dp2;
		dp1 = new int[2][4];
		dp2 = new int[2][4];
		StringTokenizer st;
		for(int i = 1; i<=1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=3; j++) {
				dp2[i][j] = dp1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 2; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = dp1[1][1];
			int y = dp1[1][2];
			int z = dp1[1][3];
			int x1 = dp2[1][1];
			int y1 = dp2[1][2];
			int z1 = dp2[1][3];
			for(int j = 1; j<=3; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(j==1) {
					dp1[1][j] = x>y?x:y;
					dp1[1][j] += a;
					
				}
				else if(j==2) {
					int t = x>y?x:y;
					dp1[1][j] = t>z?t:z;
					dp1[1][j] += a;
					
				}
				else if(j==3) {
					dp1[1][j] = y>z?y:z;
					dp1[1][j] += a;
				}
				if(j==1) {
					dp2[1][j] = x1<y1?x1:y1;
					dp2[1][j] += a;
				}
				else if(j==2) {
					int t = x1<y1?x1:y1;
					dp2[1][j] = t<z1?t:z1;
					dp2[1][j] += a;
				}
				else if(j==3) {
					dp2[1][j] = y1<z1?y1:z1;
					dp2[1][j] += a;
				}
			}
		}

		max = dp1[1][1]>dp1[1][2]?dp1[1][1]:dp1[1][2];
		max = max>dp1[1][3]?max:dp1[1][3];
		min = dp2[1][1]<dp2[1][2]?dp2[1][1]:dp2[1][2];
		min = min<dp2[1][3]?min:dp2[1][3];
		System.out.println(max+" "+min);
	}

}
