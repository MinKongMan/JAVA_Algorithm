import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_17835_meeting_220504 {
	static class find implements Comparable<find>{
		int end;
		long val;
		find(int end, long val){
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(find arg0) {
			// TODO Auto-generated method stub
			if(this.val<arg0.val) return -1; 
			return 1;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N,M,K;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<find>[] ar = new ArrayList[N+1];
		long[] array = new long[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<find>();
			array[i] = Long.MAX_VALUE;
		}
		
		for(int i =1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long z = Integer.parseInt(st.nextToken());
			ar[y].add(new find(x,z));
		}
		
		PriorityQueue<find> pq = new PriorityQueue<find>();
		boolean[] marked = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=K; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			array[x] = 0;
			pq.add(new find(x,0));
		}
		
		while(!pq.isEmpty()) {
			find node = pq.poll();
			
			if(marked[node.end]) continue;
			marked[node.end]= true;
			
			if(array[node.end]>node.val) continue;
			
			for(find temp : ar[node.end]) {
				if(array[temp.end]>array[node.end]+temp.val) {
					array[temp.end] = array[node.end]+temp.val;
					pq.add(new find(temp.end, array[temp.end]));
				}
			}
		}
		
		long value = 0;
		int ptr = 0;
		
		for(int i = 1; i<=N; i++) {
			if(array[i]>value) {
				value = array[i];
				ptr = i;
			}
		}
		System.out.println(ptr);
		System.out.println(value);
	}

}
