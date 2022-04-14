import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_7812_middleTree_220414 {
	static class xv{
		int x;
		int val;
		xv(int x, int val){
			this.x = x;
			this.val = val;
		}
	}
	static ArrayList<xv>[] ar;
	static int N;
	static long[] dp;
	static long[] array, temp_array;
	static boolean[] marked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			ar = new ArrayList[N];
			
			for(int i = 0; i<N; i++) {
				ar[i] = new ArrayList<xv>();
			}
			
			marked = new boolean[N];
			dp = new long[N];
			array = new long[N];
			
			for(int i = 1; i<=N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				ar[x].add(new xv(y,z));
				ar[y].add(new xv(x,z));
			}
			marked[0] = true;
			dfs(0);

			long k = Long.MAX_VALUE;
			marked = new boolean[N];
			marked[0] = true;
			dfs2(0);
			for(int i = 0; i<N; i++) {
				k = Math.min(dp[i],k);
			}
			sb.append(k+"\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int a) {
		array[a] = 1;
		for(xv node : ar[a]) {
			int x = node.x;
			int val = node.val;
			if(!marked[x]) {
				marked[x] = true;
				dfs(x);
				array[a] += array[x];
				dp[a] += dp[x] + array[x]*val; // array[x]*val = 현재 노드를 기준으로 연결된 노드와의 가중치 * 횟수
												// dp[a] = 인접 노드로부트 나머지 영역 총 도달 가중치((ex) 1 + 2 + 3 + 4 ...)
			}
		}
	}
	
	static void dfs2(int a) {
		for(xv node : ar[a]) {
			if(!marked[node.x]) {
				marked[node.x]= true;
				dp[node.x] = dp[a] + (N-(2*array[node.x]))*node.val;
				dfs2(node.x);
			}
		}
	}

}
