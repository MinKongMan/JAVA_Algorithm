import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_20158_running_220518 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int dir;
		int count;
		int val;
		
		xy(int x, int y, int dir, int count, int val){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			return this.val-arg0.val; 
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		int[][] array = new int[N+1][N+1];
		int[][][][] tarray = new int[4][N+1][N+1][101];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				for(int k = 0; k<4; k++) {
					Arrays.fill(tarray[k][i][j], Integer.MAX_VALUE);
				}
				if(array[i][j]==0) array[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int[] dy = {0,1,0,-1}, dx = {-1,0,1,0};
		
		pq.add(new xy(1,1,5,1,0));
		for(int i = 0; i<4; i++) {
			tarray[i][1][1][0] = 0;
		}
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			int count = node.count;
			int dir = node.dir;
			int val = node.val;
//			System.out.println(x+" "+y+" "+dir+" / "+count+" "+val);
			if(x==N && y==N) {
				System.out.println(val);
				return;
			}
			
			for(int i = 0; i<4; i++) {
				if(i==dir) {
					for(int j = 0; j<2; j++) {
						if(j==0) {
							int temp_x = x+dx[i]*(count+1);
							int temp_y = y+dy[i]*(count+1);
							if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
							if(tarray[i][temp_x][temp_y][count]<=val) continue;
							
							boolean check = false;
							int temp_xx = x;
							int temp_yy = y;
							while(true) {
								if(temp_xx == temp_x && temp_yy ==temp_y) {
									if(array[temp_x][temp_y]<=val+1) {
										check = true;
									}
									break;
								}
								if(array[temp_xx][temp_yy]<val+1) {
									check = true;
									break;
								}
								temp_xx += dx[i];
								temp_yy += dy[i];
							}
//							System.out.println(temp_xx+" "+temp_yy);
							if(check) continue;
							
							tarray[i][temp_x][temp_y][count] = val+1;
//							System.out.println(temp_x+" "+temp_y);
							pq.add(new xy(temp_x,temp_y,i,count+1,val+1));
						}
//						else {
//							int temp_x = x+dx[i];
//							int temp_y = y+dy[i];
//							if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
//							if(tarray[i][temp_x][temp_y][count]<=val) continue;
//							
//							if(array[temp_x][temp_y]<=val+1) continue;
//							
//							tarray[i][temp_x][temp_y][count] = val+1;
////							System.out.println(temp_x+" "+temp_y);
//							pq.add(new xy(temp_x,temp_y,i,1,val+1));
//						}
					}
				}
				else {
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
					if(tarray[i][temp_x][temp_y][count]<=val) continue;
					
					if(array[temp_x][temp_y]<=val+1) continue;
					
					tarray[i][temp_x][temp_y][count] = val+1;
//					System.out.println(temp_x+" "+temp_y);
					pq.add(new xy(temp_x,temp_y,i,1,val+1));
				}
			}
			
		}
		
		System.out.println("Fired");
	}

}
