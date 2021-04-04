import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_3109_breadHouse_210404 {
	static int N,M,count = 0;
	static int[][] array;
	static boolean[][] marked;
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		array = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				if(l.charAt(j-1)=='.') array[i][j] = 0;
				else array[i][j] = 1;
			}
		}
		marked = new boolean[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			if(dfs(i,1)) {
				marked[i][1] = true;
			}
		}
		System.out.println(count);
	}
	
	static boolean dfs(int a, int b) {
		if(b==M) {
			count++;
			return true;
		}
		else {
			for(int i = 0; i<3; i++) {
				int temp_x = a+dx[i];
				int temp_y = b+dy[i];
				if(temp_x<1 || temp_x>N || temp_y>M || array[temp_x][temp_y]==1 || marked[temp_x][temp_y]==true) continue;
				if(array[temp_x][temp_y]==0 && !marked[temp_x][temp_y]) {
					marked[temp_x][temp_y] = true;
					if(dfs(temp_x,temp_y)) return true;
				}
			}
			return false;
		}
	}

}
