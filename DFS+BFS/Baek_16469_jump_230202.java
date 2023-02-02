import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_16469_jump_230202 {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][M+1];
		
		int[][][] marked = new int[4][N+1][M+1];
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				array[i][j] = l.charAt(j-1)-'0';
				marked[1][i][j] = Integer.MAX_VALUE;
				marked[2][i][j] = Integer.MAX_VALUE;
				marked[3][i][j] = Integer.MAX_VALUE;
			}
		}
		
		int[][] person = new int[4][3];
		
		for(int i = 1; i<=3; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			person[i][1] = x;
			person[i][2] = y;
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qc = new LinkedList<Integer>();
				
		
		for(int i = 1; i<=3; i++) {
			int x = person[i][1];
			int y = person[i][2];
			
			qx.add(x);
			qy.add(y);
			qc.add(0);
			marked[i][x][y] = 0;
			
			while(!qx.isEmpty()) {
				int a = qx.poll();
				int b = qy.poll();
				int count = qc.poll();
				for(int j = 0; j<4; j++) {
					int temp_x = a+dx[j];
					int temp_y = b+dy[j];
					
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y]==1) continue;
					if(marked[i][temp_x][temp_y]>count+1) {
						marked[i][temp_x][temp_y] = count+1;
						qx.add(temp_x);
						qy.add(temp_y);
						qc.add(count+1);
					}
				}
			}
		}
		
		int max = Integer.MAX_VALUE;
		int counting = 0;
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(marked[1][i][j]==Integer.MAX_VALUE || marked[2][i][j]==Integer.MAX_VALUE || marked[3][i][j]==Integer.MAX_VALUE) continue;
				int min = Integer.MAX_VALUE;
				min = Math.max(marked[1][i][j], marked[2][i][j]);
				min = Math.max(min, marked[3][i][j]);
//				System.out.println(i+" "+j+" / "+marked[1][i][j]+" "+marked[2][i][j]+" "+marked[3][i][j]);
				if(min<max) {
					counting = 1;
					max = min;
				}
				else if(min==max) counting++;
			}
		}
		
		if(counting==0) System.out.println(-1);
		else {
			System.out.println(max);
			System.out.println(counting);
		}
		
	}

}
