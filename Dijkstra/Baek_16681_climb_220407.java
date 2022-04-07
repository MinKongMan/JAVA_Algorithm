import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_16681_climb_220407 {
	static class climb implements Comparable<climb>{
		int end;
		long distance;
		climb(int end, long distance ){
			this.end = end;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(climb arg0) {
			if(this.distance<arg0.distance) return -1;
			return 1;
		}
	}
	static ArrayList<climb>[] ar;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<climb> pq = new PriorityQueue<climb>();
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		long[] mountain = new long[N+1];
		long[] array_home = new long[N+1];
		long[] array_U = new long[N+1];
		ar = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<climb>();
			mountain[i] = Integer.parseInt(st.nextToken());
			array_home[i] = Long.MAX_VALUE;
			array_U[i] = Long.MAX_VALUE;
		}
		
		
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			ar[x].add(new climb(y,z));
			ar[y].add(new climb(x,z));
		}
		
		pq.add(new climb(1,0));
		boolean[] marked = new boolean[N+1];
		array_home[1] = 0;
		array_U[N] = 0;
		
		while(!pq.isEmpty()) {
			climb node = pq.poll();
			if(marked[node.end]) continue;
			marked[node.end] = true;
			
			for(climb temp_node : ar[node.end]) {
				if(mountain[node.end]>=mountain[temp_node.end]) continue;
				if(array_home[temp_node.end]>array_home[node.end]+temp_node.distance) {
					array_home[temp_node.end]=array_home[node.end]+temp_node.distance;
					pq.add(new climb(temp_node.end,array_home[temp_node.end]));
				}
			}
		}
		
		pq.add(new climb(N,0));
		marked = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			climb node = pq.poll();
			if(marked[node.end]) continue;
			marked[node.end] = true;
			
			for(climb temp_node : ar[node.end]) {
				if(mountain[node.end]>=mountain[temp_node.end]) continue;
				if(array_U[temp_node.end]>array_U[node.end]+temp_node.distance) {
					array_U[temp_node.end]=array_U[node.end]+temp_node.distance;
					pq.add(new climb(temp_node.end,array_U[temp_node.end]));
				}
			}
		}
		
//		for(int i = 1; i<=N; i++) {
//			System.out.println(array_home[i]+" "+array_U[i]);
//		}
//		System.out.println("天天天天天天天天天天");
		long answer = Long.MIN_VALUE;
		
		for(int i = 2; i<N; i++) {
			if(array_home[i]==Long.MAX_VALUE || array_U[i]==Long.MAX_VALUE) continue;
			long x1 = mountain[i]*E;
			long val = x1-array_home[i]*D-array_U[i]*D;
//			System.out.println(i+" : "+answer+" "+val+" / "+x1);
			answer = answer>val?answer:val;
		}
		
		if(answer==Long.MIN_VALUE) System.out.println("Impossible");
		else System.out.println(answer);
		
	}

}
