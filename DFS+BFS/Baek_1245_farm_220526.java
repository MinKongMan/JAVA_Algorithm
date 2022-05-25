import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1245_farm_220526 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int val;
		
		xy(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return arg0.val-this.val;
		}
		
	}
	static int N,M;
	static int[][] array;
	static boolean[][] marked;
	static int[] dx = {-1,0,1,0,1,1,-1,-1}, dy = {0,1,0,-1,1,-1,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int tx = 1;
		int ty = 1;
		
		array = new int[N+1][M+1];
		marked = new boolean[N+1][M+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1 ; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j]==0) continue;
				pq.add(new xy(i,j,array[i][j]));
			}
		}
		
		int count = 0;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			int val = node.val;
			
			if(marked[x][y]) continue;
			count++;
			marked[x][y] = true;
//			System.out.println(x+" "+y);
			dfs(x,y,val);
		}
		
		System.out.println(count);
		
	}
	
	static void dfs(int x, int y, int val) {
		for(int i = 0; i<8; i++) {
			int temp_x = x+dx[i];
			int temp_y = y+dy[i];
			if(temp_x<1 || temp_x>N || temp_y<1 || temp_y>M) continue;
			if(marked[temp_x][temp_y]) continue;
			if(array[temp_x][temp_y]>array[x][y]) continue;
			if(array[temp_x][temp_y]==0) continue;
			marked[temp_x][temp_y] = true;
			
			dfs(temp_x,temp_y,val);
		}
	}

}
