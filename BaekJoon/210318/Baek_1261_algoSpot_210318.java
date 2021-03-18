import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
class B_1261 implements Comparable<B_1261>{
	int x;
	int y;
	int wall;
	public B_1261(int x, int y, int wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
	@Override
	public int compareTo(B_1261 arg0) {
		// TODO Auto-generated method stub
		return this.wall-arg0.wall;
	}
	
}
public class Baek_1261_algoSpot_210318 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] array,array2;
	static PriorityQueue<B_1261> q_x = new PriorityQueue<B_1261>();
	static Queue<Integer> q_y = new LinkedList<Integer>();
	static boolean[][] marked;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		M = Integer.parseInt(k[0]);
		N = Integer.parseInt(k[1]);
		array = new int[N+1][M+1];
		array2 = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				array2[i][j] = Integer.MAX_VALUE;
			}
		}
		marked = new boolean[N+1][M+1];
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				int x = Integer.parseInt(l.charAt(j-1)+"");
				array[i][j] = x;
//				System.out.print(array[i][j]+" ");
			}
//			System.out.println();
		}
		BFS(1,1);
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(array2[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(array2[N][M]);
	}
	
	static void BFS(int a, int b) {
		q_x.add(new B_1261(a, b, array[a][b]));
		array2[a][b] = 0;
		while(!q_x.isEmpty()) {
			B_1261 hyo = q_x.poll();
			int x = hyo.x;
			int y = hyo.y;
			int wall = hyo.wall;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				if(marked[temp_x][temp_y] == false) {
					marked[x][y] = true;
					if(array2[temp_x][temp_y]>array2[x][y]+array[temp_x][temp_y]) {
//						System.out.println(x+" "+y+" "+array2[x][y]+" "+array[temp_x][temp_y]);
						array2[temp_x][temp_y] = array2[x][y]+array[temp_x][temp_y];
						q_x.add(new B_1261(temp_x,temp_y,array2[temp_x][temp_y]));
					}
				}
			}
		}
	}

}
