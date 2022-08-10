import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_14948_militaryRun_220810 {
	static class xy{
		int x;
		int y;
		int c;
		xy(int x, int y, int c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][M+1];
		
		int l = 0;
		int r = 1000000000;
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		int min = Integer.MAX_VALUE;
		while(l<r) {
			int mid = (l+r)/2;
			
			Queue<xy> q = new LinkedList<xy>();
			if(array[1][1]>mid) {
				l = mid+1;
				continue;
			}
			q.add(new xy(1,1,1));
			boolean[][][] marked = new boolean[3][N+1][M+1];
			marked[1][1][1] = true;
			while(!q.isEmpty()) {
				xy node = q.poll();
				int x = node.x;
				int y = node.y;
				int c = node.c;
				for(int i = 0; i<4; i++) {
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
					if(marked[c][temp_x][temp_y]) continue;
					if(c==2) {
						if(array[temp_x][temp_y]>mid) continue;
						marked[c][temp_x][temp_y] = true;
						q.add(new xy(temp_x, temp_y, c));
					}
					else {
						if(array[temp_x][temp_y]>mid) {
							temp_x += dx[i];
							temp_y += dy[i];
							if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
							if(array[temp_x][temp_y]>mid) continue;
							if(marked[c+1][temp_x][temp_y]) continue;
							marked[c+1][temp_x][temp_y] = true;
							q.add(new xy(temp_x,temp_y,2));
						}
						else {
							marked[c][temp_x][temp_y] = true;
							q.add(new xy(temp_x,temp_y,c));
						}
					}
				}
			}
//			System.out.println(mid+" "+marked[1][N][M]+" "+marked[2][N][M]);
			if(marked[1][N][M] || marked[2][N][M]) r = mid;
			else l = mid+1;
		}
		System.out.println(l);
	}

}
