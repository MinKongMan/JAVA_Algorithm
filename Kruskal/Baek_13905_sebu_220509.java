import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_13905_sebu_220509 {
	static int count = 1, N;
	static int[] parent;
	
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
			return arg0.val-this.val;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		ArrayList<find>[] ar = new ArrayList[N+1];
		parent = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
//			ar[i] = new ArrayList<find>();
		}
		
		st = new StringTokenizer(br.readLine());

		PriorityQueue<find> pq = new PriorityQueue<find>();
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
//			ar[x].add(new find(x,y,z));
//			ar[y].add(new find(y,x,z));
			pq.add(new find(x,y,z));
		}
		
//		for(find a : ar[start]) {
//			pq.add(new find(start,a.y,a.val));
//		}
		
		int min = Integer.MAX_VALUE;
		
		while(!pq.isEmpty()) {
			find node = pq.poll();
			int x = node.x;
			int y = node.y;
//			System.out.println(x+" "+y);
			if(find(parent[x])!=find(parent[y])) {
				union(x,y);
				min = Math.min(min, node.val);
				if(find(parent[start])==find(parent[end])) {
					System.out.println(min);
					return;
				}
//				for(find a : ar[x]) {
//					if(find(parent[a.y])!=find(parent[a.x])) pq.add(new find(a.x,a.y,a.val));
//				}
//				for(find a : ar[y]) {
//					if(find(parent[a.y])!=find(parent[a.x])) pq.add(new find(a.x,a.y,a.val));
//				}
			}
		}
		
		System.out.println(min);
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int x = find(parent[a]);
		int y = find(parent[b]);
		
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}

}
