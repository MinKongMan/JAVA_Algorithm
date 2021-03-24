import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2638_cheese_210325 {
	static class cheese{
		int x;
		int y;
		int count;
		cheese(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	static int[][] array;
	static int N,M,count = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] marked;
	static Queue<cheese> q = new LinkedList<cheese>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		array = new int[N+1][M+1];
		marked = new boolean[N+1][M+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j] == 1) {
					
				}
			}
		}
		boolean flag = true;
		while(flag) {
			count++;
			flag = false;
			marked = new boolean[N+1][M+1];
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					if(array[i][j]==1 && !marked[i][j]) {
						flag = true;
						q.add(new cheese(1,1,0));
						make_edge();
						q.add(new cheese(i,j,0));
						exe();
					}
				}
			}
//			for(int i= 1; i<=N; i++) {
//				for(int j = 1; j<=M; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(count-1);
	}
	
	static void make_edge() {
		while(!q.isEmpty()) {
			cheese hyo = q.poll();
			int x = hyo.x;
			int y = hyo.y;
			marked[x][y] = true;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x <1 || temp_y <1 || temp_x >N || temp_y > M || marked[temp_x][temp_y]==true) continue;
				if(array[temp_x][temp_y]==0) {
					marked[temp_x][temp_y] = true;
					q.add(new cheese(temp_x,temp_y,0));
				}
			}
		}
//		for(int i = 1; i<=N; i++) {
//			for(int j= 1; j<=M; j++) {
//				if(marked[i][j]) System.out.print("1 ");
//				else System.out.print("2 ");
//			}
//			System.out.println();
//		}
//		System.out.println("天天天天天天碳葬樹");
	}
	static void exe() {
		while(!q.isEmpty()) {
			cheese hyo = q.poll();
			int x = hyo.x;
			int y = hyo.y;
			int c = hyo.count;
//			System.out.println(x+" "+y+" "+c+" "+count);
			marked[x][y] = true;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x <1 || temp_y <1 || temp_x >N || temp_y > M ) continue;
				if(array[temp_x][temp_y]==0 && marked[temp_x][temp_y] && c>=1) {
					array[x][y] = 0;
					marked[x][y] = false;
				}
				else if(c<1 && array[temp_x][temp_y]==0 && marked[temp_x][temp_y]) {
					c++;
//					System.out.println(x+" "+y+" "+c+" "+count);
				}
				else if(array[temp_x][temp_y]==1 && !marked[temp_x][temp_y]) {
					marked[temp_x][temp_y] = true;
					q.add(new cheese(temp_x,temp_y,0));
				}
			}
		}
	}
}
