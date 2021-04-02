import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_2665_makeMiro_210402 {
	static int N;
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();
	static Queue<Integer> qz = new LinkedList<Integer>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] array;
	static int[][][] array2;
	static boolean[][][] marked;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		array2 = new int[2*N][N+1][N+1];
		marked = new boolean[2*N][N+1][N+1];
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=N; j++) {
				array[i][j] = l.charAt(j-1)-'0';
			}
		}
		qx.add(1);
		qy.add(1);
		qz.add(0);
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			int z = qz.poll();
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
				if(z+1<=(2*N-1) && array[temp_x][temp_y]==0 && !marked[z+1][temp_x][temp_y]) {
					array2[z+1][temp_x][temp_y] = array2[z][x][y]+1;
					marked[z+1][temp_x][temp_y] = true;
					qx.add(temp_x);
					qy.add(temp_y);
					qz.add(z+1);
				}
				if(array[temp_x][temp_y]==1 && !marked[z][temp_x][temp_y]) {
					array2[z][temp_x][temp_y] = array2[z][temp_x][temp_y]+1;
					marked[z][temp_x][temp_y] = true;
					qx.add(temp_x);
					qy.add(temp_y);
					qz.add(z);
				}
			}
		}
		
		if(N==1) {
			System.out.println(0);
		}
		else {
			int temp = 0;
			for(int i = 0; i<=2*N-1; i++) {
				if(array2[i][N][N]!=0) {
					temp = i;
					break;
				}
			}
			System.out.println(temp);
		}
	}

}
