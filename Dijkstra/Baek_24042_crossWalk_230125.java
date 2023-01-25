import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_24042_crossWalk_230125 {
	static class xy implements Comparable<xy>{
		int end;
		int min;
		long val;
		
		xy(int end, int min, long val){
			this.end = end;
			this.min = min;
			this.val = val;
		}

		@Override
		public int compareTo(xy o) {
			// TODO Auto-generated method stub
			if(this.val-o.val<0) return -1;
			else return 1;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		ArrayList<xy>[] ar = new ArrayList[N+1];
		long[] array = new long[N+1];
		
		for(int i = 1; i<=N; i++) {
			array[i] = Long.MAX_VALUE;
			ar[i] = new ArrayList<xy>();
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			ar[x].add(new xy(y,i-1,0));
			ar[y].add(new xy(x,i-1,0));
		}
		
		array[1] = 0;
		pq.add(new xy(1, 0, 0));
		while(!pq.isEmpty()) {
			xy node = pq.poll();
//			System.out.println(node.end+" "+node.min);
			for(xy temp_node : ar[node.end]) {
				long val = 0;
				if(array[node.end]!=Long.MAX_VALUE) {
					val = array[node.end]%M;
					if(val==0) val += temp_node.min;
					else if(val<=temp_node.min) val = temp_node.min-val;
					else val = M-val+temp_node.min;
				}
				else val = temp_node.min;
//				System.out.println(node.end+" / "+temp_node.end+" / "+" |||||||| "+array[node.end]+" "+array[temp_node.end]+" / "+val+" / "+temp_node.min);
				if(array[temp_node.end]>array[node.end]+val+1) {
					array[temp_node.end] = array[node.end]+val+1;
//					System.out.println(array[temp_node.end]);
					pq.add(new xy(temp_node.end,temp_node.min,array[temp_node.end]));
				}
			}
		}
		System.out.println(array[N]);
	}

}
