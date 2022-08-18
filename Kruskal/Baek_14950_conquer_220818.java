import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_14950_conquer_220818 {
	static class xy implements Comparable<xy>{
		int y;
		int val;
		xy(int y, int val){
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
		
		
	}
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int val = Integer.parseInt(st.nextToken());
		long ans = 0;
		ArrayList<xy>[] ar = new ArrayList[N+1];
		parent = new int[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<xy>();
			parent[i] = i;
		}
		int count = 0;
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			ar[x].add(new xy(y,z));
			ar[y].add(new xy(x,z));
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(xy node : ar[1]) {
			pq.add(node);
		}
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = 1;
			int y = node.y;
			if(find(parent[x])!=find(parent[y])) {
				union(x,y);
				ans += (val*count)+node.val;
				count++;
				for(xy temp_node : ar[y]) {
					if(find(parent[x])==find(parent[temp_node.y])) continue;
					else pq.add(temp_node);
				}
			}
		}
		System.out.println(ans);
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) {
			parent[b] = a;
		}
		else parent[a] = b;
	}

}
