import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_14618_chongKang_220711 {
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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N+1];
		int[] temp_array = new int[N+1];
		ArrayList<xy>[] ar = new ArrayList[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<xy>();
			array[i] = Integer.MAX_VALUE;
		}
		
		int Q = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int K = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		st = new StringTokenizer(br.readLine());

		for(int i = 1; i<=K; i++) {
			int a = Integer.parseInt(st.nextToken());
			temp_array[a] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=K; i++) {
			int a = Integer.parseInt(st.nextToken());
			temp_array[a] = 2;
		}
		
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			ar[x].add(new xy(y,z));
			ar[y].add(new xy(x,z));
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		pq.add(new xy(Q,0));
		array[Q] = 0;
		boolean[] marked = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			if(marked[node.y]) continue;
			marked[node.y]= true;
			
			for(xy temp_node : ar[node.y]) {
				if(array[temp_node.y]>temp_node.val+array[node.y]) {
					array[temp_node.y]= temp_node.val+array[node.y];
					pq.add(new xy(temp_node.y, array[temp_node.y]));
				}
			}
		}
		
		
		int ah = Integer.MAX_VALUE;
		int bh = Integer.MAX_VALUE;
		
		for(int i = 1; i<=N; i++) {
			if(i==Q) continue;
			if(temp_array[i]==0) continue;
			if(array[i]==Integer.MAX_VALUE) {
				continue;
			}
			if(temp_array[i]==1) {
				ah = Math.min(ah, array[i]);
			}
			else if(temp_array[i]==2) {
				bh = Math.min(bh, array[i]);
			}
		}
		if(ah==Integer.MAX_VALUE && bh==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		if(ah<=bh) {
			System.out.println("A");
			System.out.println(ah);
		}
		else {
			System.out.println("B");
			System.out.println(bh);
		}
	}

}
