import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_17070_pipe_210324 {
	static int[] dx = {0,1,1,0};
	static int[] dy = {0,0,1,1};
	static int N, max = 0;
	static int[][] array;
	static boolean[][] marked;
	static class dfs{
		int x;
		int y;
		int character;
		dfs(int x, int y, int character){
			this.x = x;
			this.y = y;
			this.character = character;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j  =1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Stack<dfs> stack = new Stack<dfs>();
		stack.push(new dfs(1,2,1));
		while(!stack.isEmpty()) {
			dfs hyo = stack.pop();
			int x = hyo.x;
			int y = hyo.y;
			int cha = hyo.character;
			int jung = 0;
			if(x==N && y == N) max++;
			else {
				for(int i = 1; i<=3; i++) {
					if(cha == i && i != 2) {
						continue;
					}
					if(i == 1) {
						jung = 3;
					}
					else if(i==3) {
						jung = 1;
					}
					else if(i==2) {
						jung = 2;
					}
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y >N || array[temp_x][temp_y]==1) continue;
					if(i==2) {
						if(array[temp_x-1][temp_y]==1 || array[temp_x][temp_y-1]==1) continue;
					}
					stack.push(new dfs(temp_x,temp_y,jung));
				}
			}
		}
		System.out.println(max);
	}

}
