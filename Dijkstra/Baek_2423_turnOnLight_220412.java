import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2423_turnOnLight_220412 {
	static int N,M;
	static int[][] array;
	
	static class find implements Comparable<find>{
		int count;
		int x;
		int y;
		int val;
		find(int x, int y, int count, int val){
			this.x = x;
			this.y = y;
			this.count = count;
			this.val = val;
		}
		@Override
		public int compareTo(find arg0) {
			return this.count-arg0.count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][M+1];
		int[] dx = {-1,0,1,0,-1,-1,1,1};
		int[] dy = {0,1,0,-1,-1,1,1,-1};
		
		PriorityQueue<find> pq = new PriorityQueue<find>();
		int[][] temp = new int[N+1][M+1];
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M;j++) {
				if(l.charAt(j-1)=='/') array[i][j] = 1;
				temp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		temp[1][1] = 0;
		
		if(array[1][1]==1) {
			temp[1][1]++;
		}
		if(array[N][M]==1) {
			array[N][M] = 0;
			temp[1][1]++;
		}
		
		pq.add(new find(1,1,temp[1][1],0));
		
		while(!pq.isEmpty()) {
			find node = pq.poll();
			for(int i = 0; i<4; i++) {
				int temp_x = node.x+dx[i];
				int temp_y = node.y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				
				if(temp[temp_x][temp_y]<=node.count) continue;
				
				if(temp_x==N && temp_y == M) {
					if(node.val == array[N][M]) continue;
					else {
						temp[temp_x][temp_y] = node.count;
						continue;
					}
				}
				
				if(array[temp_x][temp_y]==node.val) {
					temp[temp_x][temp_y] = node.count+1;
					int val = 0;
					if(node.val==1) val = 0;
					else val = 1;
					pq.add(new find(temp_x,temp_y,temp[temp_x][temp_y],val));
				}
				else {
					temp[temp_x][temp_y] = node.count;
					pq.add(new find(temp_x,temp_y,temp[temp_x][temp_y],array[temp_x][temp_y]));
				}
			}
			
			for(int i = 4; i<8; i++) {
				int temp_x = node.x+dx[i];
				int temp_y = node.y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
				if(temp[temp_x][temp_y]<=node.count+1) continue;
				
				if(temp_x==N && temp_y == M) {
					if(node.val != array[N][M]) continue;
					else {
						temp[temp_x][temp_y] = node.count;
						continue;
					}
				}
				
				if(i%2==0) {
					if(node.val==0) {
						if(node.val==array[temp_x][temp_y]) {
							temp[temp_x][temp_y] = node.count;
							pq.add(new find(temp_x,temp_y,temp[temp_x][temp_y],0));
						}
						else {
							int val = 0;
							if(node.val==0) val = 0;
							else val = 1;
							temp[temp_x][temp_y] = node.count+1;
							pq.add(new find(temp_x,temp_y,temp[temp_x][temp_y],val));
						}
					}
				}
				else {
					if(node.val==1) {
						if(node.val==array[temp_x][temp_y]) {
							temp[temp_x][temp_y] = node.count;
							pq.add(new find(temp_x,temp_y,temp[temp_x][temp_y],node.val));
						}
						else {
							int val = 0;
							if(node.val==1) val = 1;
							else val = 0;
							temp[temp_x][temp_y] = node.count+1;
							pq.add(new find(temp_x,temp_y,temp[temp_x][temp_y],val));
						}
					}
				}
			}
			
		}
		
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(temp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		if(temp[N][M]==Integer.MAX_VALUE) {
			System.out.println("NO SOLUTION");
		}
		else {
			System.out.println(temp[N][M]);
		}
	}

}
