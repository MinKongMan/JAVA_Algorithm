import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2636_cheese_210325 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M,time = 0,count = 0, area = 0;
	static int[][] array,array2;
	static boolean[][] marked;
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		boolean check = true;
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		array = new int[N+1][M+1];
		array2 = new int[N+1][M+1];
		marked = new boolean[N+1][M+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(check) {
			count++;
			marked = new boolean[N+1][M+1];
			check = false;
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					if(array[i][j]==1 && !marked[i][j]) {
						check = true;
						qx.add(1);
						qy.add(1);
						make_edge();
						qx.add(i);
						qy.add(j);
						exe();
					}
				}
			}
		}
		count--;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array2[i][j]==count) {
					area++;
				}
			}
		}
		System.out.println(count);
		System.out.println(area);
	}
	
	static void make_edge() {
		while(!qx.isEmpty()) {
			int x = qx.poll();   
			int y = qy.poll();
			marked[x][y] = true;
			for(int i= 0; i<4; i++) {
				int temp_x = dx[i]+x;
				int temp_y = dy[i]+y;
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y] == 1) continue;
				if(array[temp_x][temp_y]==0 && !marked[temp_x][temp_y]) {
					qx.add(temp_x);
					qy.add(temp_y);
					marked[temp_x][temp_y] = true;
				}
			}
		}
	}
	static void exe() {
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			marked[x][y] = true;
			for(int i= 0; i<4; i++) {
				int temp_x = dx[i]+x;
				int temp_y = dy[i]+y;
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				if(array[temp_x][temp_y]==0 && marked[temp_x][temp_y]) {
					array2[x][y] = count;
					array[x][y] = 0;
					marked[x][y] = false;
				}
				else if(array[temp_x][temp_y] == 1 && !marked[temp_x][temp_y]) {
					qx.add(temp_x);
					qy.add(temp_y);
					marked[temp_x][temp_y] = true;
				}
			}
		}
		
	}

}
