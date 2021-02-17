import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_16236_shark_210217 {
	static Queue<Integer> q_x = new LinkedList<Integer>();
	static Queue<Integer> q_y = new LinkedList<Integer>();
	static int[] d_x = {1,0,-1,0};
	static int[] d_y = {0,1,0,-1};
	static int[][] array,find,map;
	static boolean[][] marked;
	static int N, shark = 2, temp, time = 0, distance = 1, shark_x, shark_y, stack = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		temp = N*N;
		array = new int[N+1][N+1];
		find = new int[N+1][N+1];
		map = new int[N+1][N+1];
		marked = new boolean[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			String[] k = br.readLine().split(" ");
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(k[j-1]);
				if(array[i][j]==9) {
					q_x.add(i);
					q_y.add(j);
				}
			}
		}
		BFS();
	}
	static void BFS() {
		shark_x = q_x.peek();
		shark_y = q_y.peek();
		while(!q_x.isEmpty()) {
			int x = q_x.poll();
			int y = q_y.poll();
			marked[x][y] = true;
			for(int i = 0; i<4; i++) {
				int temp_x = x+d_x[i];
				int temp_y = y+d_y[i];
				if(temp_x<=N && temp_x>0 && temp_y>0 && temp_y<=N && marked[temp_x][temp_y]==false) {
					if(array[temp_x][temp_y]<=shark) {
						q_x.add(temp_x);
						q_y.add(temp_y);
						marked[temp_x][temp_y] = true;
						map[temp_x][temp_y] = map[x][y]+1;
						if(array[temp_x][temp_y]<shark && array[temp_x][temp_y]>0) {
							find[temp_x][temp_y] = map[x][y]+1;
						}
					}
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
//				System.out.print(find[i][j]+" ");
				if(find[i][j]<temp&& find[i][j]>0) {
					temp = find[i][j];
					if(q_x.isEmpty()) {
						q_x.add(i);
						q_y.add(j);
					}
					else {
						q_x.poll();
						q_y.poll();
						q_x.add(i);
						q_y.add(j);
					}
				}
			}
//			System.out.println();
		}
		
//		System.out.println(q_x.peek()+" "+q_y.peek());
		if(q_x.isEmpty()) {
			System.out.println(time);
		}
		else {
			stack++;
			grow();
			time += find[q_x.peek()][q_y.peek()];
			reset();
			temp = N*N;
			array[shark_x][shark_y] = 0;
			array[q_x.peek()][q_y.peek()] = 9;
			BFS();
		}
	}
	static void reset() {
		marked = new boolean[N+1][N+1];
		find = new int[N+1][N+1];
		map = new int[N+1][N+1];
		temp = N;
	}
	static void grow() {
		if(stack==shark) {
			shark++;
			stack = 0;
		}
	}
}
