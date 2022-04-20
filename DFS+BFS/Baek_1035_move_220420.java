import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_1035_move_220420 {
	static class xy{
		int x;
		int y;
		int number;
		xy(int x, int y, int number){
			this.x = x;
			this.y = y;
			this.number = number;
		}
	}
	static int min = Integer.MAX_VALUE;
	static int N = 1;
	static boolean[] check,temp_check = new boolean[4];
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static int[][][] ar;
	static int[] sum = new int[5], sum2 = new int[5];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] array = new int[6][6];
		
		LinkedList<xy> link = new LinkedList<xy>();
		Queue<xy> q = new LinkedList<xy>();
		
		for(int i = 1; i<=5; i++) {
			String l = br.readLine();
			for(int j = 1; j<=5; j++) {
				if(l.charAt(j-1)=='*') {
					array[i][j] = 1;
					q.add(new xy(i,j,N));
					link.add(new xy(i,j,N));
					N++;
				}
			}
		}
		
		ar = new int[N][6][6];
		boolean[][][] marked = new boolean[N][6][6];
		check = new boolean[N];
		
		for(xy temp : link) {
			marked[temp.number][temp.x][temp.y]= true;
		}
		
		
		while(!q.isEmpty()) {
			xy temp = q.poll();
			for(int i = 0; i<4; i++) {
				int temp_x = temp.x+dx[i];
				int temp_y = temp.y+dy[i];
				
				if(temp_x<1 || temp_y<1 || temp_x>5 || temp_y>5) continue;
				if(marked[temp.number][temp_x][temp_y]) continue;
				marked[temp.number][temp_x][temp_y]= true;
				ar[temp.number][temp_x][temp_y] = ar[temp.number][temp.x][temp.y] + 1;
				q.add(new xy(temp_x,temp_y,temp.number));
			}
		}
		
		for(int i = 1; i<=5; i++) {
			for(int j = 1; j<=5; j++) {
				dfs(i,j,1,0);
				if(N-1>=4) {
					for(int k = 1; k<N; k++) {
						check[k] = true;
						bfs(i,j,1,ar[k][i][j]);
						bfs2(i,j,1,ar[k][i][j]);
						check[k] = false;
					}
				}
			}
		}
		
		System.out.println(min);
		
	}
	
	static void dfs(int x, int y, int count, int val) {
		if(count==N) {
			min = min<val?min:val;
			return;
		}
		for(int i = 1; i<N; i++) {
			if(check[i]) continue;
			check[i] = true;
			for(int j = 0; j<4; j++) {
				int temp_x = x+dx[j];
				int temp_y = y+dy[j];
				if(temp_x<1 || temp_y<1 || temp_x>5 || temp_y>5) continue;
				dfs(temp_x,temp_y,count+1,ar[i][x][y]+val);
			}
			check[i] = false;
		}
	}
	
	static void bfs(int x, int y, int count, int val) {
		if(count==N-1) {

			min = min<val?min:val;
			return;
		}
		for(int i = 0; i<4; i++) {
			int temp_x = x+dx[i];
			int temp_y = y+dy[i];
			if(temp_x<1 || temp_y<1 || temp_x>5 || temp_y>5) continue;
			if(temp_check[i]) continue;
			temp_check[i] = true;
			sum[count] = i;
			for(int j = 1; j<N; j++) {
				if(check[j]) continue;
				check[j] = true;
				sum2[count] = j;
				bfs(x,y,count+1,ar[j][temp_x][temp_y]+val);
				check[j] = false;
			}
			temp_check[i] = false;
		}
	}
	
	static void bfs2(int x, int y, int count, int val) {
		if(count==4) {
			for(int i = 0; i<4; i++) {
				if(!temp_check[i]) continue;
				int temp_x = x+2*dx[i];
				int temp_y = y+2*dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>5 || temp_y>5) continue;
				for(int j = 1; j<N; j++) {
					if(check[j]) continue;
					min = min<val+ar[j][temp_x][temp_y]?min:val+ar[j][temp_x][temp_y];
				}
			}
			return;
		}
		for(int i = 0; i<4; i++) {
			int temp_x = x+dx[i];
			int temp_y = y+dy[i];
			if(temp_x<1 || temp_y<1 || temp_x>5 || temp_y>5) continue;
			if(temp_check[i]) continue;
			temp_check[i] = true;
			sum[count] = i;
			for(int j = 1; j<N; j++) {
				if(check[j]) continue;
				check[j] = true;
				sum2[count] = j;
				bfs2(x,y,count+1,ar[j][temp_x][temp_y]+val);
				check[j] = false;
			}
			temp_check[i] = false;
		}
	}
}
