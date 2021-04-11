import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1956_exercise_210411 {
	static class find implements Comparable<find>{
		int end;
		int val;
		find(int end, int val){
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(find arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		PriorityQueue<find> pq = new PriorityQueue<find>();
		int N = Integer.parseInt(k[0]);
		int M = Integer.parseInt(k[1]);
		ArrayList<find>[] ar = new ArrayList[N+1];
		int[][] array = new int[N+1][N+1];
		boolean[][] marked = new boolean[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<find>();
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.MAX_VALUE;
			}
		}
		StringTokenizer st;
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ar[a].add(new find(b,c));
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i<=N; i++) {
			pq.add(new find(i,0));
			array[i][i] = 0;
			while(!pq.isEmpty()) {
				find hyo = pq.poll();
				int x = hyo.end;
				if(!marked[i][x]) {
					marked[i][x] = true;
					for(find sin : ar[x]) {
						if(array[i][sin.end]>array[i][x]+sin.val) {
							array[i][sin.end]= array[i][x]+sin.val;
							pq.add(new find(sin.end,array[i][sin.end]));
						}
					}
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				if(array[i][j]==Integer.MAX_VALUE || array[j][i]==Integer.MAX_VALUE) continue;
				min = min<array[i][j]+array[j][i]?min:array[i][j]+array[j][i];
			}
		}
		System.out.println(min==Integer.MAX_VALUE?"-1":min);
	}

}
