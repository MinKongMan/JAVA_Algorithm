import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2140_find_230210 {
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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][N+1];
		int[][] temp_array = new int[N+1][N+1];
		boolean[][] marked = new boolean[N+1][N+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		int[] dx = {-1,-1,-1,0,1,1,1,0}, dy = {-1,0,1,1,1,0,-1,-1};
		
		int bomb = 0;
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j =1 ; j<=N; j++) {
				if(l.charAt(j-1)=='#') {
					array[i][j] = -9;
					temp_array[i][j] = -9;
				}
				else {
					array[i][j] = l.charAt(j-1)-'0';
					temp_array[i][j] = array[i][j];
				}
				if(array[i][j]!=-9) {
					pq.add(new xy(i,j,array[i][j]));
				}
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(array[i][j]==-9) {
					boolean check = false;
					for(int k = 0; k<8; k++) {
						int temp_x = i+dx[k];
						int temp_y = j+dy[k];
						
						if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
						if(array[temp_x][temp_y]>=0) {
							check = true;
							break;
						}
					}
					
					if(!check) {
						marked[i][j] = true;
						bomb++;
					}
				}
			}
		}

		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int count = 0;
			
			int x = node.x;
			int y = node.y;
			if(marked[x][y]) continue;
			if(temp_array[x][y]==0) {
				marked[x][y] = true;
				for(int i = 0; i<8; i++) {
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N || marked[temp_x][temp_y]) continue;
					if(temp_array[temp_x][temp_y]==-9) {
						marked[temp_x][temp_y] = true;
					}
				}
			}
			else {
				for(int i = 0; i<8; i++) {
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N || marked[temp_x][temp_y]) continue;
					if(temp_array[temp_x][temp_y]==-9) count++;
				}
				
				if(temp_array[x][y]==count) {
					bomb += count;
					marked[x][y] = true;
					for(int i = 0; i<8; i++) {
						int temp_x = x+dx[i];
						int temp_y = y+dy[i];
						
						if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N || marked[temp_x][temp_y]) continue;
						if(temp_array[temp_x][temp_y]==-9) {
							marked[temp_x][temp_y] = true;
							for(int j = 0; j<8; j++) {
								int temp_xx = temp_x+dx[j];
								int temp_yy = temp_y+dy[j];
								
								if(temp_xx<1 || temp_yy<1 || temp_xx>N || temp_yy>N || marked[temp_xx][temp_yy]) continue;
								if(temp_array[temp_xx][temp_yy]>=1) temp_array[temp_xx][temp_yy]--;
							}
						}
					}
				}
			}
			
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					if(marked[i][j]) continue;
					if(temp_array[i][j]>=0) pq.add(new xy(i,j,temp_array[i][j]));
				}
			}
		}
		System.out.println(bomb);
		

	}

}
