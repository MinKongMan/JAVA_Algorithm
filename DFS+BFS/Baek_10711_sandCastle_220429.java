import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_10711_sandCastle_220429 {
	static int N,M;
	static int[][] array, temp_array, val;
	static int[] dx = {-1,0,1,0,-1,1,1,-1}, dy = {0,1,0,-1,1,1,-1,-1};
	static class xy{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][M+1];
		temp_array = new int[N+1][M+1];
		
		Queue<xy> q = new LinkedList<xy>();
		Queue<xy> temp_q = new LinkedList<xy>();
		Queue<xy> temp_qq = new LinkedList<xy>();
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				if(l.charAt(j-1)=='.') array[i][j] = 0;
				else array[i][j] = l.charAt(j-1)-'0';
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				int count = 0;
				if(array[i][j]==0 || array[i][j]==9) continue;
				for(int k = 0; k<8; k++) {
					int temp_x = i+dx[k];
					int temp_y = j+dy[k];
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
					if(array[temp_x][temp_y]==0) count++;
				}
				if(count>=array[i][j]) q.add(new xy(i,j));
			}
		}
		
		int count = 0;
		
		boolean[][] marked = new boolean[N+1][M+1];
		
		while(true) {
			while(!q.isEmpty()) {
				xy node = q.poll();
				int x = node.x;
				int y = node.y;
				int counting = 0;
				if(marked[x][y]) continue;
				for(int k = 0; k<8; k++) {
					int temp_x = x+dx[k];
					int temp_y = y+dy[k];
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
					if(array[temp_x][temp_y]==0) counting++;
				}
				if(counting>=array[x][y]) {
					marked[x][y] = true;
					temp_q.add(new xy(x,y));
				}
			}
			
			if(temp_q.isEmpty()) break;
//			System.out.println("天天天天天天天天天天天天天天天天天天"+temp_q.size()+" / "+temp_q.peek().x+" "+temp_q.peek().y);
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=M; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
			while(!temp_q.isEmpty()) {
				xy node = temp_q.poll();
				int x = node.x;
				int y = node.y;
//				System.out.println(x+" "+y+" / "+array[x][y]);
				array[x][y] = 0;
				for(int i = 0; i<8; i++) {
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
					if(array[temp_x][temp_y]>0 && array[temp_x][temp_y]<9) {
						q.add(new xy(temp_x, temp_y));
					}
				}
			}
//			System.out.println("天天天天天天天天天");
			count++;
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=M; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
			
		}
		
		System.out.println(count);
	}

	
}
