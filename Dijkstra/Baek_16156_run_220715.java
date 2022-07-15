import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_16156_run_220715 {

	static class xy implements Comparable<xy>{
		int x;
		int y;
		int index;
		long val;
		xy(int x, int y, int idx, long val){
			this.x = x;
			this.y = y;
			this.val = val;
			this.index = idx;
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[][] array = new long[N+1][M+1];
		long[][] ar_val = new long[N+1][M+1];
		int[][] id_val = new int[N+1][M+1];
		
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				ar_val[i][j] = Long.MAX_VALUE;
			}
		}
		
		int[] answer = new int[N+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			pq.add(new xy(i,M,i,array[i][M]));
			ar_val[i][M] = array[i][M];
		}
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			
			int x = node.x;
			int y = node.y;
//			if(y==1) answer[node.index]++;         1)
			
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				if(ar_val[temp_x][temp_y]>array[temp_x][temp_y]+node.val) {
					ar_val[temp_x][temp_y] = array[temp_x][temp_y]+node.val;
					id_val[temp_x][temp_y] = node.index;
					pq.add(new xy(temp_x,temp_y,node.index,ar_val[temp_x][temp_y]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
//		for(int i = 1; i<=N; i++) {
//			answer[id_val[i][1]]++;                2)
//		}
		
		
		for(int i = 1; i<=N; i++) {
			sb.append(answer[i]+"\n");
		}
		System.out.println(sb);
	}
}
