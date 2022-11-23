import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1726_robot_221123 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int val;
		int dir;
		
		xy(int x, int y, int dir, int val){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
		
	}
	static int N,M,sx,sy,sd,ex,ey,ed;
	static int[][] array;
	static int[][][] ar;
	static PriorityQueue<xy> pq = new PriorityQueue<xy>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][M+1];
		ar = new int[5][N+1][M+1];
		
		for(int i =1 ; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1 ; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				for(int k = 1; k<=4; k++) {
					ar[k][i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());
		
		ar[sd][sx][sy] = 0;
		pq.add(new xy(sx,sy,sd,0));
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			check(node);
			check2(node);
//			System.out.println(node.x+" "+node.y+" "+node.dir+" / "+ar[node.dir][node.x][node.y]);
		}
		
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		ed = Integer.parseInt(st.nextToken());
		
		System.out.println(ar[ed][ex][ey]);
	}
	
	static void check2(xy node) {
		int x = node.x;
		int y = node.y;
		int dir = node.dir;
		for(int i =1 ; i<=3; i++) {
			int temp_x = x;
			int temp_y = y;
			if(dir==1) {
				temp_y += i;
			}
			else if(dir==2) {
				temp_y -= i;
			}
			else if(dir==3) {
				temp_x += i;
			}
			else {
				temp_x -= i;
			}
			if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) return;
			if(array[temp_x][temp_y]==1) return;
			if(ar[dir][temp_x][temp_y]>ar[dir][x][y]+1) {
				ar[dir][temp_x][temp_y] = ar[dir][x][y]+1;
				pq.add(new xy(temp_x,temp_y,dir,ar[dir][temp_x][temp_y]));
			}
		}
	}
	
	static void check(xy node) {
		int x = node.x, y = node.y;
		if(node.dir==1) {
			if(ar[2][x][y]>ar[1][x][y]+2) {
				ar[2][x][y] = ar[1][x][y]+2;
				pq.add(new xy(x,y,2,ar[2][x][y]));
			}
			if(ar[3][x][y]>ar[1][x][y]+1) {
				ar[3][x][y] = ar[1][x][y]+1;
				pq.add(new xy(x,y,3,ar[3][x][y]));
			}
			if(ar[4][x][y]>ar[1][x][y]+1) {
				ar[4][x][y] = ar[1][x][y]+1;
				pq.add(new xy(x,y,4,ar[4][x][y]));
			}
		}
		
		else if(node.dir==2) {
			if(ar[1][x][y]>ar[2][x][y]+2) {
				ar[1][x][y] = ar[2][x][y]+2;
				pq.add(new xy(x,y,1,ar[1][x][y]));
			}
			if(ar[3][x][y]>ar[2][x][y]+1) {
				ar[3][x][y] = ar[2][x][y]+1;
				pq.add(new xy(x,y,3,ar[3][x][y]));
			}
			if(ar[4][x][y]>ar[2][x][y]+1) {
				ar[4][x][y] = ar[2][x][y]+1;
				pq.add(new xy(x,y,4,ar[4][x][y]));
			}
		}
		
		else if(node.dir==3) {
			if(ar[4][x][y]>ar[3][x][y]+2) {
				ar[4][x][y] = ar[3][x][y]+2;
				pq.add(new xy(x,y,4,ar[4][x][y]));
			}
			if(ar[1][x][y]>ar[3][x][y]+1) {
				ar[1][x][y] = ar[3][x][y]+1;
				pq.add(new xy(x,y,1,ar[1][x][y]));
			}
			if(ar[2][x][y]>ar[3][x][y]+1) {
				ar[2][x][y] = ar[3][x][y]+1;
				pq.add(new xy(x,y,2,ar[2][x][y]));
			}
		}
		else if(node.dir==4) {
			if(ar[3][x][y]>ar[4][x][y]+2) {
				ar[3][x][y] = ar[4][x][y]+2;
				pq.add(new xy(x,y,3,ar[3][x][y]));
			}
			if(ar[1][x][y]>ar[4][x][y]+1) {
				ar[1][x][y] = ar[4][x][y]+1;
				pq.add(new xy(x,y,1,ar[1][x][y]));
			}
			if(ar[2][x][y]>ar[4][x][y]+1) {
				ar[2][x][y] = ar[4][x][y]+1;
				pq.add(new xy(x,y,2,ar[2][x][y]));
			}
		}
	}

}
