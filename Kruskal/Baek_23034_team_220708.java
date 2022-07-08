import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek_23034_team_220708 {
	static class xy implements Comparable<xy>{
		int y;
		int x;
		int val;
		
		xy(int x, int y, int val){
			this.y = y;
			this.val = val;
			this.x = x;
		}

		@Override
		public int compareTo(xy o) {
			// TODO Auto-generated method stub
			return this.val-o.val;
		}
		
	}
	
	static int[] parent;
	static int[][] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] ar = new ArrayList[N+1];
		parent = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
			ar[i] = new ArrayList<Integer>();
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		array = new int[N+1][N+1];
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			array[x][y] = z;
			array[y][x] = z;
			
			pq.add(new xy(x,y,z));
		}
		
		long val = 0;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			if(find(parent[x])!=find(parent[y])) {
				union(x,y);
				val += node.val;
				ar[x].add(y);
				ar[y].add(x);
			}
		}
		
		int tc = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=tc; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			boolean[] marked = new boolean[N+1];
			
			Queue<Integer> qx = new LinkedList<Integer>();
			Queue<Integer> qc = new LinkedList<Integer>();
			qx.add(a);
			qc.add(0);
			marked[a] = true;
			while(!qx.isEmpty()) {
				int x = qx.poll();
				int c = qc.poll();
				if(x==b) {
					sb.append(val-c+"\n");
					break;
				}
				
				for(int node : ar[x]) {
					int temp_val = 0;
					if(marked[node]) continue;
					marked[node] = true;
					temp_val = Math.max(c,  array[x][node]);
					qx.add(node);
					qc.add(temp_val);
				}
			}
		}
		System.out.println(sb);
		
		
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int x = find(parent[a]);
		int y = find(parent[b]);
		
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}

}
