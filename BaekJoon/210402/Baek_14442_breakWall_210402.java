import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_14442_breakWall_210402 {
	static int N,M,K;
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();
	static Queue<Integer> qz = new LinkedList<Integer>();
	static boolean[][][] marked;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][][] array2;
	static int[][] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		K = Integer.parseInt(k[2]);
		array = new int[N+1][M+1];
		marked = new boolean[K+1][N+1][M+1];
		array2 = new int[K+1][N+1][M+1];
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=l.length(); j++) {
				if(l.charAt(j-1)=='0') array[i][j] = 0;
				else if(l.charAt(j-1)=='1') array[i][j] = 1;
			}
		}
		qx.add(1);
		qy.add(1);
		qz.add(0);
		marked[0][1][1] = true;
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			int z = qz.poll();
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				if(z+1<=K && array[temp_x][temp_y]==1 && !marked[z+1][temp_x][temp_y]) {
					marked[z+1][temp_x][temp_y] = true;
					array2[z+1][temp_x][temp_y] = array2[z][x][y]+1;
					qx.add(temp_x);
					qy.add(temp_y);
					qz.add(z+1);
				}
				if(!marked[z][temp_x][temp_y] && array[temp_x][temp_y]==0) {
					marked[z][temp_x][temp_y] = true;
					array2[z][temp_x][temp_y] = array2[z][x][y]+1;
					qx.add(temp_x);
					qy.add(temp_y);
					qz.add(z);
				}
			}
			
		}
		int min = Integer.MAX_VALUE;
		if(N==M && N==1) {
			System.out.println(1);
		}
		else {
			for(int i = 1; i<=K; i++) {
				if(array2[i][N][M]!=0) {
					min = min<array2[i][N][M]?min:array2[i][N][M];
				}
			}
			System.out.println(min==Integer.MAX_VALUE?"-1":(min+1));
		}
	}

}
