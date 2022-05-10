import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Baek_2406_network_220510 {
	static class find implements Comparable<find>{
		int x;
		int y;
		int val;
		
		find(int x, int y, int val)
		{
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(find arg0) {
			// TODO Auto-generated method stub
			return -arg0.val+this.val;
		}
		
	}
	static int[] parent;
	static int N,M;
	static boolean[][] marked;
	static int[][] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		array = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(find(parent[x])!=find(parent[y])) union(x,y);
		}
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<find> pq = new PriorityQueue<find>();
		
		for(int i = 2; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				if(find(parent[i])!=find(parent[j])) {
					pq.add(new find(i,j,array[i][j]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int val = 0;
		int count = 0;
		
		while(!pq.isEmpty()) {
			find node = pq.poll();
			if(find(parent[node.x])!=find(parent[node.y])) {
				sb.append(node.x+" "+node.y+"\n");
				union(node.x,node.y);
				val += node.val;
				count++;
			}
		}
		
		System.out.println(val+" "+count);
		System.out.println(sb);

	}
	
	public static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = find(parent[x]); 
	}
	
	public static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}

}
