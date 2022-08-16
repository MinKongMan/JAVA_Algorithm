import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_24513_zombie_220816 {
	static class xy{
		int x;
		int y;
		int val;
		int count;
		xy(int x, int y, int val, int count){
			this.x = x;
			this.y = y;
			this.val = val;
			this.count = count;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][M+1];
		int[][] ar = new int[N+1][M+1];
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		
		Queue<xy> q = new LinkedList<xy>();
		boolean[][] marked = new boolean[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j]==1 || array[i][j]==2) {
					q.add(new xy(i,j,array[i][j],0));
					marked[i][j] = true;
				}
			}
		}
		
		
		
		while(!q.isEmpty()) {
			xy node = q.poll();
			int x = node.x;
			int y = node.y;
			if(array[x][y]==3) continue;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				if(array[temp_x][temp_y]==-1) continue;
				if(array[temp_x][temp_y]==0) {
					array[temp_x][temp_y] = array[x][y];
					ar[temp_x][temp_y] = node.count+1;
					q.add(new xy(temp_x, temp_y, array[temp_x][temp_y],node.count+1));
				}
				else if(array[temp_x][temp_y]!=0) {
					if(array[x][y]==1 && array[temp_x][temp_y]==2 && ar[temp_x][temp_y] == ar[x][y]+1) {
						array[temp_x][temp_y] += array[x][y];
					}
					else if(array[x][y]==2 && array[temp_x][temp_y]==1 && ar[temp_x][temp_y] == ar[x][y]+1) {
						array[temp_x][temp_y] = 3;
					}
				}
			}
		}
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array[i][j]==1) count1++;
				else if(array[i][j]==2) count2++;
				else if(array[i][j]==3) count3++;
			}
		}
		
		System.out.println(count1+" "+count2+" "+count3);
		
		
		
	}

}
