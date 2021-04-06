import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Baek_11000_roomSelect_210406 {
	static class pq implements Comparable<pq>{
		int end;
		pq(int end){
			this.end = end;
		}
		@Override
		public int compareTo(pq o) {
			// TODO Auto-generated method stub
			return this.end-o.end;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int [N+1][2];
		boolean[] marked = new boolean[N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array,new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				if(arg0[0]==arg1[0]) {
					return arg0[1]-arg1[1];
				}
				else {
					return arg0[0]-arg1[0];
				}
			}
		}
		);
		PriorityQueue<pq> q = new PriorityQueue<pq>();
		q.add(new pq(0));
		for(int i = 1; i<=N; i++) {
			if(array[i][0]>=q.peek().end) {
				q.poll();
				q.add(new pq(array[i][1]));
			}
			else q.add(new pq(array[i][1]));
		}
//		while(!q.isEmpty()) {
//			System.out.println(q.poll().end);
//		}
		System.out.println(q.size());
	}

}
