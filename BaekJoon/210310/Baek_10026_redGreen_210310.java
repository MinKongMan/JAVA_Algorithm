import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10026_redGreen_210310 {
	static int[][] array,array2;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int N, temp1 = 0, temp2 = 0;
	static boolean[][] marked,marked2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		array2 = new int[N+1][N+1];
		marked = new boolean[N+1][N+1];
		marked2 = new boolean[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			String k = br.readLine();
			for(int j = 0; j<N; j++) {
				if(k.charAt(j)=='G'||k.charAt(j)=='R') {
					array[i][j+1] = 1;
				}
				else if(k.charAt(j)=='B') {
					array[i][j+1] = 2;
				}
				if(k.charAt(j)=='G') {
					array2[i][j+1] = 1;
				}
				else if(k.charAt(j)=='R') {
					array2[i][j+1] = 2;
				}
				else if(k.charAt(j)=='B') {
					array2[i][j+1] = 3;
				}
			}
		}
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=N; j++) {
//				System.out.print(array2[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(marked[i][j]==false) {
					temp1++; // »ö¸Í
					DFS(i,j);
				}
				if(marked2[i][j]==false) {
					temp2++; // »ö¸Í ¾Æ´Ô
					DFS2(i,j);
				}
			}
		}
		System.out.println(temp2+" "+temp1);
	}
	
	static void DFS(int a, int b) {
		if(marked[a][b]==true) return;
		
		marked[a][b] = true;
		for(int i = 0; i<4; i++) {
			int x = a+dx[i];
			int y = b+dy[i];
			if(x<1 || y<1 || x>N || y>N) continue;
			if(marked[x][y]==false && array[x][y]==array[a][b]) {
				DFS(x,y);
			}
		}
	}
	
	static void DFS2(int a, int b) {
		if(marked2[a][b]==true) return;
		marked2[a][b] = true;
		
		for(int i = 0; i<4; i++) {
			int x = a+dx[i];
			int y = b+dy[i];
			if(x<1 || y<1 || x>N || y>N) continue;
			if(marked2[x][y]==false && array2[x][y]==array2[a][b]) {
				DFS2(x,y);
			}
		}
	}

}
