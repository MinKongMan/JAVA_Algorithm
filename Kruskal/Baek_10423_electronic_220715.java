import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_10423_electronic_220715 {
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
			if(this.val<arg0.val)return -1; 
			else return 1;
		}
	}
	static ArrayList<xy>[] ar;
	static boolean[] marked;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ar = new ArrayList[N+1];
		marked = new boolean[N+1];
		parent = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<xy>();
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=K; i++) {
			marked[Integer.parseInt(st.nextToken())] = true; 
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq.add(new xy(x,y,z));
		}
		
		int val = 0;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			if(marked[find(parent[x])] && marked[find(parent[y])]) continue;
			if(find(parent[x])!=find(parent[y])) {
				union(x,y);
				val += node.val;
			}
		}
		
//		for(int i = 1; i<=N; i++) {
//			System.out.println(i+" "+find(parent[i]));
//		}
		System.out.println(val);
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
//		System.out.print(x+" "+y+" / "+a+" "+b+" ");
		if(marked[a] || marked[b]) {
			if(marked[a]) {
				parent[b] = a;
			}
			else {
				parent[a] = b;
			}
		}
		else {
			if(a<b) {
				parent[b] = a;
			}
			else {
				parent[a] = b;
			}
		}
//		System.out.println(find(parent[x])+" "+find(parent[y]));
	}
}
