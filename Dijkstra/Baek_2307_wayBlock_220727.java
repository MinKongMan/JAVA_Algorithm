import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2307_wayBlock_220727 {
	static class xy implements Comparable<xy>{
		int end;
		int val;
		
		xy(int end, int val){
//			this.start = start;
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
		
	}
	static ArrayList<Integer>[] ar2;
	static Queue<xy> q = new LinkedList<xy>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[M+1][3];
		int[] parent = new int[N+1];
		
		
		ar2 = new ArrayList[N+1];
		
		ArrayList<xy>[] ar = new ArrayList[N+1];
		
		for(int i = 1; i<=N; i++) {
			parent[i] = Integer.MAX_VALUE;
			ar[i] = new ArrayList<xy>();
			ar2[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			ar[x].add(new xy(y,val));
			ar[y].add(new xy(x,val));
			array[i][1] = x;
			array[i][2] = y;
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		pq.add(new xy(1,0));
		parent[1] = 0;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.end;
			
			for(xy temp_node :ar[x]) {
				if(parent[temp_node.end]>parent[x]+temp_node.val) {
					parent[temp_node.end]= parent[x]+temp_node.val;
					pq.add(new xy(temp_node.end,parent[temp_node.end]));
					ar2[temp_node.end].clear();
					ar2[temp_node.end].add(x);
				}
			}
		}
		
		int max = 0;
		
//		for(int i = 1; i<=M; i++) {
//			pq.add(new xy(0,1,0));
////			int[] parent2 = new int[N+1];
////			Arrays.fill(parent2[i], Integer.MAX_VALUE);
//			
//			pq.add(new xy(0,1,0));
//			parent2[i][1] = 0;
//			
//			while(!pq.isEmpty()) {
//				xy node = pq.poll();
//				int x = node.end;
//				
//				for(xy temp_node :ar[x]) {
//					if((x==array[i][1] && temp_node.end==array[i][2]) || (x==array[i][2] && temp_node.end==array[i][1])) continue;
//					if(parent2[i][temp_node.end]>parent2[i][x]+temp_node.val) {
//						parent2[i][temp_node.end]= parent2[i][x]+temp_node.val;
//						pq.add(new xy(0,temp_node.end,parent2[i][temp_node.end]));
//					}
//				}
//			}
//			
//			if(parent2[i][N]==Integer.MAX_VALUE) {
//				System.out.println(-1);
//				return;
//			}
//			else {
//				if(parent2[i][N]>parent[N]) {
//					max = Math.max(parent2[i][N]-parent[N],max);
//				}
//			}
//		}
//		System.out.println(max);
		dfs(N);
		while(!q.isEmpty()) {
			xy node1 = q.poll();
			int x = node1.end;
			int y = node1.val;
			int[] parent2 = new int[N+1];
			Arrays.fill(parent2, Integer.MAX_VALUE);
			
			pq.add(new xy(1,0));
			parent2[1] = 0;
			
			while(!pq.isEmpty()) {
				xy node = pq.poll();
				
				for(xy temp_node : ar[node.end]) {
					if((temp_node.end==x && node.end == y) || (node.end==x && temp_node.end==y)) continue;
					if(parent2[temp_node.end]>temp_node.val+parent2[node.end]) {
						parent2[temp_node.end]= temp_node.val +parent2[node.end];
						pq.add(new xy(temp_node.end, parent2[temp_node.end]));
					}
				}
			}
			
			if(parent2[N]==Integer.MAX_VALUE) {
				System.out.println(-1);
				return;
			}
			else {
				if(parent2[N]>parent[N]) {
					max = Math.max(parent2[N]-parent[N],max);
				}
			}
		}
		System.out.println(max);
	}
	
	
	static void dfs(int x) {
		for(int a:ar2[x]) {
			q.add(new xy(x,a));
			dfs(a);
		}
	}

}
