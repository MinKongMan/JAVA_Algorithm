import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_18223_minjoon_220422 {
	static class xy_1 implements Comparable<xy_1>{
		int y;
		int garnet;
		int val;
		xy_1(int y, int val){
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy_1 o) {
			// TODO Auto-generated method stub
			if(this.val<o.val) return -1;
			else return 1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<xy_1>[] ar = new ArrayList[N+1];
		int[] parent = new int[N+1];
		int[] parent2 = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<xy_1>();
			parent[i] = Integer.MAX_VALUE;
			parent2[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			ar[x].add(new xy_1(y,val));
			ar[y].add(new xy_1(x,val));
		}
		
		PriorityQueue<xy_1> pq = new PriorityQueue<xy_1>();
		pq.add(new xy_1(1,0));
		parent[1] = 0;
		boolean[] marked = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			xy_1 node = pq.poll();
			
			if(marked[node.y]) continue;
			marked[node.y] = true;
			
			for(xy_1 temp_node : ar[node.y]) {
				if(parent[temp_node.y]>parent[node.y]+temp_node.val) {
					parent[temp_node.y]= parent[node.y]+temp_node.val;
					pq.add(new xy_1(temp_node.y, parent[temp_node.y]));
				}
			}
		}
		
		
		pq.add(new xy_1(X,0));
		parent2[X] = 0;
		marked = new boolean[N+1];
		while(!pq.isEmpty()) {
			xy_1 node = pq.poll();
			
			if(marked[node.y]) continue;
			marked[node.y] = true;
			
			for(xy_1 temp_node : ar[node.y]) {
				if(parent2[temp_node.y]>parent2[node.y]+temp_node.val) {
					parent2[temp_node.y]= parent2[node.y]+temp_node.val;
					pq.add(new xy_1(temp_node.y, parent[temp_node.y]));
				}
			}
		}
		if(parent[N]<parent[X]+parent2[N]) {
			System.out.println("GOOD BYE");
		}
		else {
			System.out.println("SAVE HIM");
		}
	}

}
