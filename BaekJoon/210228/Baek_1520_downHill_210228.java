import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1520_downHill_210228 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();
	static int[][] array,array2;
	static boolean[][] marked;
	static int N,M,count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
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
		array2[N][M] = 1;
		dfs(1,1);
		
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(array2[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(array2[1][1]);
	}
//		qx.add(1);
//		qy.add(1);
//		while(!qx.isEmpty()) {
//			int x = qx.poll();
//			int y = qy.poll();
//			if(x==N && y==M) {
//				count ++;
//			}
//			else {
//				for(int i = 0; i<4; i++) {
//					int temp_x = x+dx[i];
//					int temp_y = y+dy[i];
//					if(temp_x>0 && temp_y>0 && temp_x<=N && temp_y<=M && x>0 && y>0 && x<=N && y<=M) {
//						if(array[temp_x][temp_y]<array[x][y]) {
//							qx.add(temp_x);
//							qy.add(temp_y);
//						}
//					}
//				}
//			}
//		dfs(1,1);
	
	static void dfs(int a, int b) {
		if(a==N && b==M) {
			return;
		}
		if(array2[a][b]!=0 || marked[a][b]==true){
			return;
		}
		for(int i = 0; i<4; i++) {
			int temp_x = a+dx[i];
			int temp_y = b+dy[i];
			if( temp_x<=0 || temp_y<=0 || temp_x>N || temp_y>M) continue;
			if((array[temp_x][temp_y]<array[a][b])) {
				
				dfs(temp_x,temp_y);
				marked[a][b] = true;
				array2[a][b] += array2[temp_x][temp_y];
			}
		}
	}
//	static void dfs(int a, int b) {
//		if(a == 1 && b == 1) {
//			return;
//		}
//		else {
//			int x = a;
//			int y = b;
//			for(int i = 0; i<4; i++) {
//				int temp_x = x+dx[i];
//				int temp_y = y+dy[i];
//				if(x>0 && y>0 && temp_x>0 && temp_y>0 && x<=N && y<=M && temp_x<=N && temp_y<=M) {
//					if(array[temp_x][temp_y]>array[x][y] && array2[temp_x][temp_y]==0) {
//						array2[temp_x][temp_y]+=array2[x][y];
//						dfs(temp_x,temp_y);
//					}
//					else if(array[temp_x][temp_y]>array[x][y] && array2[temp_x][temp_y]>0) {
//						array2[temp_x][temp_y]+=array2[x][y];
//					}
//				}
//			}
//		}
//	}
}
