import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_17144_microDust_210328 {
	static class cleaner{
		int x;
		int y;
		cleaner(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();
	static int[][] array,array2;
	static LinkedList<cleaner> link = new LinkedList<cleaner>();
	static int N,M,V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		V = Integer.parseInt(k[2]);
		array = new int[N+1][M+1];
		array2 = new int[N+1][M+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j]==-1) {
					link.add(new cleaner(i,j));
				}
				else if(array[i][j]!=0) {
					qx.add(i);
					qy.add(j);
				}
			}
		}
		int l = 0;
		while(l<V) {
			array2 = new int[N+1][M+1];
			while(!qx.isEmpty()) {
				int x = qx.poll();
				int y = qy.poll();
				int temp = 0;
				for(int i = 0; i<4; i++) {
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y]==-1) continue;
					array2[temp_x][temp_y] += array[x][y]/5;
					temp++;
				}
				array2[x][y] = array2[x][y]-(temp)*(array[x][y]/5);
			}
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					if(array[i][j]==-1) continue;
					array[i][j] += array2[i][j];
				}
			}
			for(int i = 0; i<2; i++) {
				clean(link.get(i).x,link.get(i).y);
			}
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					if(array[i][j]>0) {
						qx.add(i);
						qy.add(j);
					}
				}
			}
			l++;
		}
		int count = 0;
		for(int i = 1; i<=N; i++) {
			for(int j= 1; j<=M; j++) {
				if(array[i][j]==-1) continue;
				count+=array[i][j];
			}
		}
		System.out.println(count);
	}
	
	static void clean(int a, int b) {
		if(array[a-1][b]==-1) {
			for(int i = a+1; i<=N; i++) {
				if(array[i-1][1] == -1) array[i][1] = 0;
				else {
					array[i-1][1] = array[i][1];
					array[i][1] = 0;
				}
			}
			for(int i = 2; i<=M; i++) {
				array[N][i-1] = array[N][i];
				array[N][i] = 0;
			}
			for(int i = N-1; i>=a; i--) {
				array[i+1][M] = array[i][M];
				array[i][M] = 1;
			}
			for(int i = M-1; i>1; i--) {
				array[a][i+1] = array[a][i];
				array[a][i] = 0;
			}
		}
		if(array[a+1][b]==-1) {
			for(int i = a-1; i>=1; i--) {
				if(array[i+1][1]==-1) array[i][1] = 0;
				else {
					array[i+1][1] = array[i][1];
					array[i][1] = 0;
				}
			}
			for(int i = 2; i<=M; i++) {
				array[1][i-1] = array[1][i];
				array[1][i] = 0;
			}
			for(int i = 2; i<=a; i++) {
				array[i-1][M] = array[i][M];
				array[i][M] = 0;
			}
			for(int i = M-1; i>1; i--) {
				array[a][i+1] = array[a][i];
				array[a][i] = 0;
			}
		}
	}
	

}
