import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_27498_love_230302 {
	static int[] parent;
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int val;
		
		xy(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return -this.val+arg0.val;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) parent[i] = i;
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
		
			if(d==1) union(x,y);
			else pq.add(new xy(x,y,z));
		}
		
		long val = 0;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			
			int x = node.x;
			int y = node.y;
			
			if(find(parent[x])!=find(parent[y])) {
				union(x,y);
			}
			else {
//				System.out.println(x+" "+y);
				val += node.val;
			}
		}
		System.out.println(val);
	}

	static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
}
