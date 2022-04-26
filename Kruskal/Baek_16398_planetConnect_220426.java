import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_16398_planetConnect_220426 {
	static class find implements Comparable<find>{
		int x;
		int y;
		int val;
		find(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(find arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
		
	}
	static int[] parent;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int[][] array = new int[N+1][N+1];
		parent = new int[N+1];
		PriorityQueue<find> pq = new PriorityQueue<find>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			parent[i] = i;
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				pq.add(new find(i,j,array[i][j]));
			}
		}
		
		long sum = 0;
		
		while(!pq.isEmpty()) {
			find q = pq.poll();
			int x = q.x;
			int y = q.y;
			if(find(parent[x])!=find(parent[y])){
				sum += q.val;
				union(x,y);
			}
		}
		System.out.println(sum);
	}
	
	
	static int find(int x) {
		if(x==parent[x]) return parent[x];
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}

}
