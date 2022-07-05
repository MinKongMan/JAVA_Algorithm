import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_15709_check_220705 {
	static class xy implements Comparable<xy>{
		int y;
		long val;
		xy(int y, long val){
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			if(this.val<arg0.val) return -1;
			else return 1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int t = N+M;
		
		long[][] array = new long[Q+1][N+M+Q+1];
		ArrayList<xy>[] ar = new ArrayList[N+M+Q+1];
		
		for(int i = 1; i<=N+M+Q; i++) {
			for(int j = 1; j<=Q; j++) {
				array[j][i] = Long.MAX_VALUE;
			}
			ar[i] = new ArrayList<xy>();
		}
		
		for(int i = 1; i<=S; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			ar[x].add(new xy(y,z));
			ar[y].add(new xy(x,z));
		}
		
		for(int i = N+M+1; i<=Q+N+M; i++) {
			boolean[] marked = new boolean[N+M+Q+1];
			PriorityQueue<xy> pq = new PriorityQueue<xy>();
			pq.add(new xy(i,0));
			array[i-t][i] = 0;
			
			while(!pq.isEmpty()) {
				xy node = pq.poll();
				if(marked[node.y]) continue;
				marked[node.y]= true;
				
				for(xy temp_node : ar[node.y]) {
					if(array[i-t][temp_node.y]>array[i-t][node.y]+temp_node.val) {
						array[i-t][temp_node.y]= array[i-t][node.y]+temp_node.val;
						pq.add(new xy(temp_node.y,array[i-t][temp_node.y]));
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=T; i++) {
			long min = Long.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = 1; j<=Q; j++) {
				if(array[j][x]==Long.MAX_VALUE || array[j][y]==Long.MAX_VALUE) continue;
				min = Math.min(min, array[j][x]+array[j][y]);
			}
			if(min==Long.MAX_VALUE) sb.append(-1+"\n");
			else sb.append(min+"\n");
		}
		System.out.println(sb);

	}

}
