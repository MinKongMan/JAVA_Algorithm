import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_17396_backdoor_220728 {
	static class xy implements Comparable<xy>{
		int end;
		long val;
		xy(int end, long val){
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			if(this.val-arg0.val<0) return -1;
			else return 1;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] array = new long[N];
		
		ArrayList<xy>[] ar = new ArrayList[N];
		
		for(int i = 0; i<N; i++) {
			ar[i] = new ArrayList<xy>();
			array[i] = Long.MAX_VALUE;
		}
		
		boolean[] marked = new boolean[N];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x==1) {
				marked[i] = true;
			}
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			ar[x].add(new xy(y,val));
			ar[y].add(new xy(x,val));
		}
		
		boolean[] checked = new boolean[N];
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		pq.add(new xy(0,0));
		array[0] = 0;
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			
			if(checked[node.end]) continue;
			checked[node.end] = true;
			for(xy temp_node : ar[node.end]) {
				if(temp_node.end==N-1) {
					if(array[temp_node.end]>array[node.end]+temp_node.val) {
						array[temp_node.end] = array[node.end]+temp_node.val;
						pq.add(new xy(temp_node.end, array[temp_node.end]));
					}
				}
				else {
					if(marked[temp_node.end]) continue;
					if(array[temp_node.end]>array[node.end]+temp_node.val) {
						array[temp_node.end] = array[node.end]+temp_node.val;
						pq.add(new xy(temp_node.end, array[temp_node.end]));
					}
				}
			}
		}
		if(array[N-1]==Long.MAX_VALUE) System.out.println(-1);
		else {
			System.out.println(array[N-1]);
		}

	}

}
