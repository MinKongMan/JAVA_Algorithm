import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_22116_out_220525 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int count;
		xy(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
		@Override
		public int compareTo(xy arg0) {
			return this.count-arg0.count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][N+1];
		int[][] temp_array = new int[N+1][N+1];
		boolean[][] marked = new boolean[N+1][N+1];
		
		for(int i =1 ; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				temp_array[i][j] = Integer.MAX_VALUE;
			}
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		pq.add(new xy(1,1,0));
		temp_array[1][1] = 0;
		
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			int count = node.count;
			
			if(marked[x][y]) continue;
			marked[x][y] = true;
			
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				
				if(temp_x<1 || temp_x>N || temp_y<1 || temp_y>N) continue;
				int temp_val = Math.abs(array[x][y]-array[temp_x][temp_y]);
				int temp_max = Math.max(temp_val, count);
				if(temp_array[temp_x][temp_y]>temp_max) {
					temp_array[temp_x][temp_y] = temp_max;
					pq.add(new xy(temp_x,temp_y,temp_max));
				}
			}
		}
		System.out.println(temp_array[N][N]);

	}

}
