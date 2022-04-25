import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2325_gaeko_220425 {
	static class xy implements Comparable<xy>{
		int x;
		int val;
		xy(int x, int y){
			this.x = x;
			this.val = y;
		}
		
		@Override
		public int compareTo(xy arg0) {
			return this.val-arg0.val;
		}
	}
	static ArrayList<Integer>[] ar;
	static ArrayList<xy>[] array;
	static boolean[][] check;
	static int N,M;
	static PriorityQueue<xy> pq = new PriorityQueue<xy>();
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new ArrayList[N+1];
		array = new ArrayList[N+1];
		int[] parent = new int[N+1];
		check = new boolean[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
			array[i] = new ArrayList<xy>();
			parent[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			array[x].add(new xy(y,z));
			array[y].add(new xy(x,z));
			
		}
		
		
		
		pq.add(new xy(1,0));
		parent[1] = 0;
		
		boolean[] marked = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			if(marked[node.x]) continue;
			marked[node.x]= true;
			
			for(xy temp_node : array[node.x]) {
				if(parent[temp_node.x]>temp_node.val+parent[node.x]) {
					ar[temp_node.x].clear();
					ar[temp_node.x].add(node.x);
					
					parent[temp_node.x] = temp_node.val+parent[node.x];
					pq.add(new xy(temp_node.x,parent[temp_node.x]));
				}
			}
		}
		dfs(N);
		System.out.println(max);
	}

	static void dfs(int a) {
		for(int x : ar[a]) {
			find(x,a);
			dfs(x);
		}
	}
	
	static void find(int x, int y) {
		int[] parent = new int[N+1];
		Arrays.fill(parent, Integer.MAX_VALUE);
		pq.add(new xy(1,0));
		parent[1] = 0;
		boolean[] marked = new boolean[N+1];
		
		check[x][y] = true;
		check[y][x] = true;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			if(marked[node.x]) continue;
			marked[node.x]= true;
			
			for(xy temp_node : array[node.x]) {
				if(check[temp_node.x][node.x]) continue; 
				if(parent[temp_node.x]>temp_node.val+parent[node.x]) {
					ar[temp_node.x].clear();
					ar[temp_node.x].add(node.x);
					
					parent[temp_node.x] = temp_node.val+parent[node.x];
					pq.add(new xy(temp_node.x,parent[temp_node.x]));
				}
			}
		}
		
		max = max>parent[N]?max:parent[N];
		check[x][y] = false;
		check[y][x] = false;
	}
}
