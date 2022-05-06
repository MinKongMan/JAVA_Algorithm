import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2611_race_220506 {
	static class find{
		int y;
		int val;
		find(int y, int val){
			this.y = y;
			this.val = val;
		}
	}
	
	static int N;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		int[] array = new int[N+1];
		ArrayList<find>[] ar = new ArrayList[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<find>();
		}
		
		for(int i = 1; i<=M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 int z = Integer.parseInt(st.nextToken());
			 
			 ar[x].add(new find(y,z));
			 array[y]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(1);
		
		int[] dp = new int[N+1];
		parent = new int[N+1];
		boolean[] marked = new boolean[N+1];
		
		while(!q.isEmpty()) {
			int node = q.poll();
			if(marked[node]) continue;
			marked[node] = true;
			for(find temp : ar[node]) {
				array[temp.y]--;
				
				if(array[temp.y]==0) {
					q.add(temp.y);
				}
				
				if(dp[temp.y] < dp[node] + temp.val ) {
//					System.out.println(node+" "+temp.y+" / "+dp[temp.y]+" / "+(dp[node]+temp.val));
					dp[temp.y] = dp[node]+temp.val;
					parent[temp.y] = node;
					
				}
				
			}
		}
		
		System.out.println(dp[1]);
//		for(int i = 1; i<=N; i++) {
//			System.out.println(i+" / "+parent[i]);
//		}
		System.out.print(1+" ");
		dfs(parent[1]);
		System.out.println(1);
	}
	
	public static void dfs(int a) {
		if(a==1) return;
		dfs(parent[a]);
		System.out.print(a+" ");
		
	}

}
