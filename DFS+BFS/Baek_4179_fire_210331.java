import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_4179_fire_210331 {
	static class exit{
		int x;
		int y;
		exit(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[][] array, array2, array3;
	static int N,M,min = Integer.MAX_VALUE;
	static boolean[][] marked, marked2;
	static LinkedList<exit> link = new LinkedList<exit>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<exit> p_x = new LinkedList<exit>();
	static Queue<exit> f_x = new LinkedList<exit>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		int kx = 0,ky = 0;
		array = new int[N+1][M+1];
		array2 = new int[N+1][M+1];
		array3 = new int[N+1][M+1];
		marked = new boolean[N+1][M+1];
		marked2 = new boolean[N+1][M+1];
		link.add(new exit(0,0));
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				if(l.charAt(j-1)=='#') {
					array[i][j] = 1;
				}
				else if(l.charAt(j-1)=='.') {
					array[i][j] = 0;
				}
				else if(l.charAt(j-1)=='J') {
					p_x.add(new exit(i,j));
					marked[i][j] = true;
					array[i][j] = 2;
					array2[i][j] = 1;
					kx = i;
					ky = j;
				}
				else if(l.charAt(j-1)=='F') {
					f_x.add(new exit(i,j));
					marked2[i][j] = true;
					array[i][j] = 9;
					array3[i][j] = 1;
				}
			}
		}
		BFS1();
		BFS2();
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(i==1 || j==M || i==N || j==1) {
					if(array[i][j]==0) link.add(new exit(i,j));
				}
			}
		}
		
		if(kx==N || kx==1 || ky == 1 || ky == M) {
			System.out.println(1);
		}
		else {
			BFS1();
			BFS2();
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=M; j++) {
//					System.out.print(array2[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=M; j++) {
//					System.out.print(array3[i][j]+" ");
//				}
//				System.out.println();
//			}
			for(int i = 1; i<link.size(); i++) {
				int x = link.get(i).x;
				int y = link.get(i).y;
				if(array2[x][y]<array3[x][y] && array3[x][y]!=0) {
					min = min<array2[x][y]?min:array2[x][y];
				}
				else if(array3[x][y]==0 && array2[x][y]!=0) {
					min = min<array2[x][y]?min:array2[x][y];
				}
				
			}
			System.out.println(min==Integer.MAX_VALUE?"IMPOSSIBLE":(min));
			}
	}
	
	static void BFS1() {
		while(!p_x.isEmpty()) {
			exit hyo = p_x.poll();
			int x = hyo.x;
			int y = hyo.y;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y]==1) continue;
				if(!marked[temp_x][temp_y]) {
					marked[temp_x][temp_y] = true;
					array2[temp_x][temp_y] = array2[x][y]+1;
					p_x.add(new exit(temp_x,temp_y));
				}
			}
		}
	}
	
	static void BFS2() {
		while(!f_x.isEmpty()) {
			exit hyo = f_x.poll();
			int x = hyo.x;
			int y = hyo.y;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y]==1) continue;
				if(!marked2[temp_x][temp_y]) {
					marked2[temp_x][temp_y] = true;
					array3[temp_x][temp_y] = array3[x][y]+1;
					f_x.add(new exit(temp_x,temp_y));
				}
			}
		}
	}

}
