import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_16932_make_220602 {
	static int N,M,count = 0,area = 0;
	static int[][] array,val,temp_val;
	static boolean[][] marked;
	static boolean[] check;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static Queue<Integer> qx,qy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		qx = new LinkedList<Integer>();
		qy = new LinkedList<Integer>();
		
		array = new int[N+1][M+1];
		val = new int[N+1][M+1];
		marked = new boolean[N+1][M+1];
		temp_val = new int[N+1][M+1];
		
		int max = 0;
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(marked[i][j]) continue;
				if(array[i][j]==1) {
					area++;
					marked[i][j] = true;
					dfs(i,j);
				}
				while(!qx.isEmpty()) {
					int x = qx.poll();
					int y = qy.poll();
					val[x][y] = count;
					temp_val[x][y] = area;
				}
				max = Math.max(max, count);
				count = 0;
			}
		}
		
		check = new boolean[area+1];
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array[i][j]==1) continue;
				else {
					int temp_c = 1;
					for(int k = 0; k<4; k++) {
						int temp_x = i+dx[k];
						int temp_y = j+dy[k];
						
						if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
						if(check[temp_val[temp_x][temp_y]]) continue;
						check[temp_val[temp_x][temp_y]] = true;
						temp_c += val[temp_x][temp_y];
					}
					max = Math.max(max, temp_c);
					
					for(int k = 0; k<4; k++) {
						int temp_x = i+dx[k];
						int temp_y = j+dy[k];
						
						if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
						check[temp_val[temp_x][temp_y]] = false;
					}
				}
			}
		}
		
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(val[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(max);
	}
	
	static void dfs(int a, int b) {
		
		count++;
		qx.add(a);
		qy.add(b);
		for(int i = 0; i<4; i++) {
			int temp_x = a+dx[i];
			int temp_y = b+dy[i];
			if(temp_x<1 || temp_x>N || temp_y<1 ||temp_y>M) continue;
			if(array[a][b]!=array[temp_x][temp_y] || marked[temp_x][temp_y]) continue;
			
			marked[temp_x][temp_y] = true;
			
			dfs(temp_x,temp_y);
		}
	}

}
