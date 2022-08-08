import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2412_climb_220808 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int idx;
		long val;
		
		xy(int x, int y, int idx, long val){
			this.x = x;
			this.y = y;
			this.idx = idx;
			this.val = val;
		}
		@Override 
		public int compareTo(xy arg0) {
			if(this.val<arg0.val)return -1;
			else return 1;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] parent = new long[N+1];
		ArrayList<xy>[] ar = new ArrayList[M+1];
		for(int i = 0; i<=M; i++) {
			ar[i] = new ArrayList<xy>();
		}
		for(int i = 1; i<=N; i++) {
			parent[i] = Integer.MAX_VALUE;
		}
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ar[y].add(new xy(x,y,i,0));
		}
		
		pq.add(new xy(0,0,0,0));
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			for(int i = -2; i<=2; i++) {
				if(y+i<0 || y+i>M) continue;
				for(xy temp_node : ar[y+i]) {
					if(Math.abs(x-temp_node.x)<=2) {
						if(parent[temp_node.idx]>node.val+1) {
							parent[temp_node.idx]= node.val+1;
							pq.add(new xy(temp_node.x, temp_node.y, temp_node.idx, parent[temp_node.idx]));
						}
					}
				}
			}
		}
		
		long min = Integer.MAX_VALUE;
		
		for(xy node : ar[M]) {
			min = Math.min(parent[node.idx],  min);
		}
		if(min== Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

}
