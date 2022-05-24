import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1445_date_220524 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int gar;
		int next;
		xy(int x, int y, int gar, int next){
			this.x = x;
			this.y = y;
			this.gar = gar;
			this.next = next;
		}
		
		@Override
		public int compareTo(xy arg0) {
			if(this.gar==arg0.gar) return this.next-arg0.next; 
			return this.gar-arg0.gar;
		}
	}
	static int N,M;
	static int[][] array;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static boolean[][] marked = new boolean[N+1][M+1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][M+1];
		int[][] garbage = new int[N+1][M+1];
		int[][] gar_next = new int[N+1][M+1];
		marked = new boolean[N+1][M+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		int start_x = 0;
		int start_y = 0;
		int end_x = 0;
		int end_y = 0;
		
		for(int i =1 ; i<=N; i++) {
			String l = br.readLine();
			for(int j =1 ; j<=M; j++) {
				garbage[i][j] = Integer.MAX_VALUE;
				gar_next[i][j] = Integer.MAX_VALUE;
				if(l.charAt(j-1)=='S') {
					start_x = i;
					start_y = j;
					array[i][j] = 5;
				}
				else if(l.charAt(j-1)=='F') {
					end_x = i;
					end_y = j;
					array[i][j] = 9;
				}
				else if(l.charAt(j-1)=='g') {
					array[i][j] = 1;
				}
				
			}
		}
		
		
		
		int count = 0;
		
		pq.add(new xy(start_x,start_y,0,count));
		garbage[start_x][start_y] = 0;
		gar_next[start_x][start_y] = count;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			if(marked[x][y]) continue;
			marked[x][y] = true;
			int gar = node.gar;
			int next = node.next;
//			System.out.println("½ÃÀÛ Á¡ : "+x+" "+y+" / "+gar+" "+next);
			
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				if(temp_x==end_x && temp_y==end_y) {
					System.out.println(gar+" "+(next));
					return;
				}
				if(array[temp_x][temp_y]==1) {
					pq.add(new xy(temp_x,temp_y,gar+1,next));
				}
				else {
					boolean mark = true;
					for(int j = 0; j<4; j++) {
						int temp_xx = temp_x+dx[j];
						int temp_yy = temp_y+dy[j];
						if(temp_xx<1 || temp_yy<1 || temp_xx>N || temp_yy>M) continue;
						if(array[temp_xx][temp_yy]==1) {
//							System.out.println(temp_x+" "+temp_y+" / "+temp_xx+" "+temp_yy);
							pq.add(new xy(temp_x,temp_y,gar,next+1));
							mark =false;
							break;
						}
					}
					if(mark) pq.add(new xy(temp_x,temp_y,gar,next));
				}
			}
		}
	}
}
