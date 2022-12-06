import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_21772_spEat_221206 {
	static int N,M,K,max=0,sx,sy;
	static int[][] array;
	static int[] dx = {0,-1,0,1,0}, dy = {0,0,1,0,-1};
	static boolean[][] marked;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		array = new int[N+1][M+1];
		marked = new boolean[N+1][M+1];
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				if(l.charAt(j-1)=='G') {
					sx = i;
					sy = j;
					array[i][j] = 9;
				}
				else if(l.charAt(j-1)=='S') {
					array[i][j] = 5;
				}
				else if(l.charAt(j-1)=='#') {
					array[i][j] = 1;
				}
			}
		}
		dfs(sx,sy,0,0);
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int t, int count) {
		if(t>K) return;
		max = Math.max(max, count);
		for(int i = 0; i<5; i++) {
			int temp_x = x+dx[i];
			int temp_y = y+dy[i];
			
			if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
			if(array[temp_x][temp_y]==1) continue;
			if(i==0) {
				dfs(temp_x,temp_y,t+1,count);
			}
			else {
				if(array[temp_x][temp_y]==5) {
					if(marked[temp_x][temp_y]) {
						dfs(temp_x,temp_y,t+1,count);
					}
					else {
						marked[temp_x][temp_y] = true;
						dfs(temp_x,temp_y,t+1,count+1);
						marked[temp_x][temp_y] = false;
					}
				}
				else {
					dfs(temp_x,temp_y,t+1,count);
				}
			}
		}
	}

}
