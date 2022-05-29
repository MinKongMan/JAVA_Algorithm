import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_13422_thief_220530 {

	static int N,T;
	static int[] array;
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			array = new int[N+M+1];
			dp = new long[N+M+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
				dp[i] = dp[i-1]+array[i];
			}
			for(int i = N+1; i<=N+M; i++) {
				array[i] = array[i-N];
				dp[i] = dp[i-1]+array[i];
			}
			
//			for(int i = 1; i<=N; i++) {
//				System.out.print(dp[i]+" ");
//			}
//			System.out.println();
			
			int count = 0;
			if(N!=M) {
			for(int i = 0; i<N; i++) {
				long x = dp[i+M]-dp[i];
//				System.out.println(x);
				if(x>=K) continue;
				else count++;
			}
//			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			}
			else {
				long x = dp[N];
				if(x>=K) {
					
				}
				else count++;
			}
			sb.append(count+"\n");
		}
		
		System.out.println(sb);

	}

}
