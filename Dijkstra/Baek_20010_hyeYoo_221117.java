import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_20010_hyeYoo_221117 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int val;
		
		xy(int x, int y,int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
	}
	
	static class pq implements Comparable<pq>{
		int end;
		int val;
		pq(int end, int val){
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(pq o) {
			// TODO Auto-generated method stub
			return this.val-o.val;
		}
		
	}
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<pq>[] ar = new ArrayList[N+1];
		int[][] array = new int[N+1][N+1];
		parent = new int[N+1];
		for(int i = 0; i<=N; i++) {
			parent[i] = i;
			Arrays.fill(array[i], Integer.MAX_VALUE);
			ar[i] = new ArrayList<pq>();
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq.add(new xy(x,y,z));
		}
		
		int sum = 0;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			if(find(parent[node.x])!=find(parent[node.y])) {
				union(node.x,node.y);
				sum += node.val;
				ar[node.x].add(new pq(node.y,node.val));
				ar[node.y].add(new pq(node.x,node.val));
			}
		}
		
		System.out.println(sum);
		PriorityQueue<pq> pq2 = new PriorityQueue<pq>();
		
		for(int i = 0; i<N; i++) {
			array[i][i] = 0;
			pq2.add(new pq(i,0));
			
			while(!pq2.isEmpty()) {
				pq node = pq2.poll();
				for(pq temp_node : ar[node.end]) {
					if(array[i][temp_node.end]>array[i][node.end]+temp_node.val) {
						array[i][temp_node.end] = array[i][node.end]+temp_node.val;
						pq2.add(new pq(temp_node.end,array[i][temp_node.end]));
					}
				}
			}
		}
		
		int max = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
//				System.out.print(array[i][j]+" ");
				max = Math.max(array[i][j], max);
			}
		}
		System.out.println(max);
	}
	
	
	static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}

}
