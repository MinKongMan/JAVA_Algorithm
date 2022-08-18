import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_24463_miro_220818 {

	static int[][] array;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static boolean[][] marked;
	static int min = Integer.MAX_VALUE, sx = 0, sy = 0, ex = 0, ey = 0, N, M;
	static boolean check = false;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][M+1];
		marked = new boolean[N+1][M+1];
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j =1 ; j<=M; j++) {
				if(l.charAt(j-1)=='+') {
					array[i][j] = -1;
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			if(array[i][1]==0) {
				if(check) {
					ex = i;
					ey = 1;
				}
				else {
					sx = i;
					sy = 1;
					check = true;
				}
			}
		}
		
		for(int i = 1; i<=N; i++) {
			if(array[i][M]==0) {
				if(check) {
					ex = i;
					ey = M;
				}
				else {
					sx = i;
					sy = M;
					check = true;
				}
			}
		}
		
		for(int i = 1; i<=M; i++) {
			if(array[1][i]==0) {
				if(check) {
					ex = 1;
					ey = i;
				}
				else {
					sx = 1;
					sy = i;
					check = true;
				}
			}
		}
		
		for(int i = 1; i<=M; i++) {
			if(array[N][i]==0) {
				if(check) {
					ex = N;
					ey = i;
				}
				else {
					sx = N;
					sy = i;
					check = true;
				}
			}
		}
//		System.out.println(sx+" "+sy+" "+ex+" "+ey);
		marked[sx][sy] = true;
		dfs(sx, sy, 1);
		marked[sx][sy] = true;
		dfs2(sx, sy, 1);
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, int val) {
		if(x==ex && y==ey) {
			min = Math.min(val, min);
			return;
		}
		for(int i = 0; i<4; i++) {
			int temp_x = dx[i]+x;
			int temp_y = y+dy[i];
			if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
			if(marked[temp_x][temp_y]) continue;
			if(array[temp_x][temp_y]==-1) continue;
			marked[temp_x][temp_y] = true;
			dfs(temp_x, temp_y, val+1);
			marked[temp_x][temp_y] = false;
		}
		marked[x][y] = false;
	}
	
	static void dfs2(int x, int y, int val) {
		if(x==ex && y==ey) {
			if(val!=min) return;
			else {
				for(int i = 1; i<=N; i++) {
					for(int j = 1; j<=M; j++) {
						if(array[i][j]==-1) sb.append("+");
						else if(array[i][j]==0) {
							if(marked[i][j]) sb.append(".");
							else sb.append("@");
						}
					}
					sb.append("\n");
				}
			}
			return;
		}
		for(int i = 0; i<4; i++) {
			int temp_x = dx[i]+x;
			int temp_y = y+dy[i];
			if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
			if(marked[temp_x][temp_y]) continue;
			if(array[temp_x][temp_y]==-1) continue;
			marked[temp_x][temp_y] = true;
			dfs2(temp_x, temp_y, val+1);
			marked[temp_x][temp_y] = false;
		}
		marked[x][y] = false;
	}

}
