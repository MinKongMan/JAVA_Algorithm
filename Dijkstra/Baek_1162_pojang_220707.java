import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1162_pojang_220707 {
	static class xy implements Comparable<xy>{
		int y;
		int count;
		long val;
		
		xy(int y, long val, int count){
			this.y = y;
			this.val = val;
			this.count = count;
		}

		@Override
		public int compareTo(xy o) {
			// TODO Auto-generated method stub
			if(this.val<o.val) return -1;
			else return 1;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<xy>[] ar = new ArrayList[N+1];
		long[][] dp = new long[K+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<xy>();
			for(int j = 0; j<=K; j++) {
				dp[j][i] = Long.MAX_VALUE;
			}
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			ar[x].add(new xy(y,z,0));
			ar[y].add(new xy(x,z,0));
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		boolean[][] marked = new boolean[K+1][N+1];
		dp[0][1] = 0;
		pq.add(new xy(1,dp[0][1],0));
		while(!pq.isEmpty()) {
			xy node = pq.poll();
//			System.out.println(node.y+" "+node.count);
			if(marked[node.count][node.y]) continue;
			marked[node.count][node.y] = true; 
//			System.out.println(node.y+" "+node.count);
			for(xy temp_node : ar[node.y]) {
//				System.out.println(node.count+" / "+node.y+" "+temp_node.y+" / "+dp[node.count][temp_node.y]+" "+dp[node.count+1][temp_node.y]);
				if(dp[node.count][temp_node.y]>dp[node.count][node.y]+temp_node.val) {
					dp[node.count][temp_node.y] = dp[node.count][node.y]+temp_node.val;
//					System.out.println(node.y+" "+dp[node.count][temp_node.y]+" "+node.count);
					pq.add(new xy(temp_node.y, dp[node.count][temp_node.y], node.count));
				}
				if(node.count<K && dp[node.count+1][temp_node.y]>dp[node.count][node.y]) {
					dp[node.count+1][temp_node.y] = dp[node.count][node.y];
					pq.add(new xy(temp_node.y, dp[node.count+1][temp_node.y], node.count+1));
				}
//				System.out.println(node.count+" / "+node.y+" "+temp_node.y+" / "+dp[node.count][temp_node.y]+" "+dp[node.count+1][temp_node.y]);
			}
		}
		
		long min = Long.MAX_VALUE;
		for(int i= 0; i<=K; i++) {
			min = Math.min(min, dp[i][N]);
//			for(int j = 1; j<=N; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
		}
		System.out.println(min);
		
		
	}

}
