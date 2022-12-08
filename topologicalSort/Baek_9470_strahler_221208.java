import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_9470_strahler_221208 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int test = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
		
			ArrayList<Integer>[] ar = new ArrayList[M+1];
			int[] array = new int[M+1];
			int[] dp = new int[M+1];
			int[] count = new int[M+1];
			
			for(int i = 1; i<=M; i++) {
				ar[i] = new ArrayList<Integer>();
			}
			
			for(int i = 1; i<=K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ar[x].add(y);
				array[y]++;
			}
			
			Queue<Integer> qx = new LinkedList<Integer>();
			
			for(int i = 1; i<=M; i++) {
				if(array[i]==0) {
					qx.add(i);
					dp[i] = 1;
					count[i] = 1;
				}
			}
			
			while(!qx.isEmpty()) {
				int x = qx.poll();
				if(count[x]>1) dp[x]++;
				for(int i : ar[x]) {
					array[i]--;
					if(array[i]==0) {
						qx.add(i);
					}
					if(dp[i]<dp[x]) {
						dp[i] = dp[x];
						count[i] = 1;
					}
					else if(dp[i]==dp[x]) {
						count[i]++;
					}
				}
				
//				for(int i = 1; i<=M; i++) {
//					System.out.println(x+" / "+i+" "+dp[i]+" / "+array[i]);
//				}
//				System.out.println("天天天天天天天天天天天天");
			}
			sb.append(N+" "+dp[M]+"\n");
		}
		System.out.println(sb);
	}

}
