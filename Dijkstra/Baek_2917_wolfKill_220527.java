import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2917_wolfKill_220527 {

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
			return this.val-arg0.val;
		}
	}
	
	static class xy2 implements Comparable<xy2>{
		int x;
		int y;
		int val;
		
		xy2(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(xy2 arg0) {
			// TODO Auto-generated method stub
			return -this.val+arg0.val;
		}
	}
	static int N,M;
	static int[][] array, temp_array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int start_x = 0;
		int end_x = 0;
		int start_y = 0;
		int end_y = 0;
		
		array = new int[N+1][M+1];
		temp_array = new int[N+1][M+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j =1 ; j<=M; j++) {
				temp_array[i][j] = Integer.MAX_VALUE;
				if(l.charAt(j-1)=='V') {
					array[i][j] = 5;
					start_x = i;
					start_y = j;
				}
				else if(l.charAt(j-1)=='J') {
					array[i][j] = 9;
					end_x = i;
					end_y = j;
				}
				else if(l.charAt(j-1)=='+') {
					array[i][j] = 1;
					pq.add(new xy(i,j,0));
					temp_array[i][j] = 0;
				}
			}
		}
		
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			int val = node.val;
			
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				if(temp_array[temp_x][temp_y]>val+1) {
					temp_array[temp_x][temp_y] = val+1;
					pq.add(new xy(temp_x,temp_y,val+1));
				}
			}
		}
		
		PriorityQueue<xy2> pq2 = new PriorityQueue<xy2>();
		pq2.add(new xy2(start_x,start_y,temp_array[start_x][start_y]));
		
		int count = Integer.MAX_VALUE;
		boolean[][] marked = new boolean[N+1][M+1];
		marked[start_x][start_y] = true;
		while(!pq2.isEmpty()) {
			xy2 node = pq2.poll();
			int x = node.x;
			int y = node.y;
			int val = node.val;
			count = Math.min(val, count);
			if(x==end_x && y==end_y) {
				System.out.println(count);
			}
			
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				if(marked[temp_x][temp_y]) continue;
				marked[temp_x][temp_y] = true;
				pq2.add(new xy2(temp_x,temp_y,temp_array[temp_x][temp_y]));
			}
		}

	}

}
