import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1890_jump_210303 {
	static int N;
	static long[][] array,dp;
	static boolean[][] marked;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new long[110][110];
		dp = new long[110][110];
		marked = new boolean[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[N][N]=1;
		DFS(1,1,array[1][1]);
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=N; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[1][1]);
	}
	static void DFS(int a, int b, long c) {
		if(b>N || a>N) {
			return;
		}
		else if(b==N && a==N) {
//			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ최종ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=N; j++) {
//					System.out.print(dp[i][j]+" ");
//				}
//				System.out.println();
//			}
			return;
		}
		if(marked[a][b]==false) {
			marked[a][b] = true;
			DFS(a,(int) (b+c),array[a][b+(int)c]);
			dp[a][b] = dp[a][(int) (b+c)]+dp[a][b];
			DFS((int) (a+c),b,array[(int) (a+c)][b]);
			dp[a][b] = dp[a][b]+dp[(int) (a+c)][b];
		}
		else {
//			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ갱신ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=N; j++) {
//					System.out.print(dp[i][j]+" ");
//				}
//				System.out.println();
//			}
			return;
		}
	}
}
