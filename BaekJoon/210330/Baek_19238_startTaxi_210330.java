import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_19238_startTaxi_210330 {
	static int[][] array,array2,array4;
	static int[][][] array3;
	static int N,M,min = Integer.MAX_VALUE, gas = 0,a,b,c,d, e_x,e_y,count;
	static Queue<Integer> q_x = new LinkedList<Integer>();
	static Queue<Integer> q_y = new LinkedList<Integer>();
	static boolean[][] marked;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		gas = Integer.parseInt(k[2]);
		array = new int[N+1][N+1];
		array2 = new int[N+1][N+1];
		array4 = new int[N+1][N+1];
		array3 = new int[M+1][N+1][N+1];
		marked = new boolean[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		k = br.readLine().split(" ");
		int x = Integer.parseInt(k[0]);
		int y = Integer.parseInt(k[1]);
		array[x][y] = 9;
		q_x.add(x);
		q_y.add(y);
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			array4[a][b] = i;
			array3[i][c][d] = -array4[a][b];
		}
		
		count = 0;
		while(count<M) {
			x = q_x.peek();
			y = q_y.peek();
			int val = 0;
			min = Integer.MAX_VALUE;
			
			find();
			q_x.clear();
			q_y.clear();
			
			if(min == -1) {
				min = 0;
				q_x.add(x);
				q_y.add(y);
				array[x][y] = 9;
				val = array4[x][y];
				array4[x][y] = 0;
			}
			else {
			forout:
				for(int i = 1; i<=N; i++) {
					for(int j = 1; j<=N; j++) {
						if(array2[i][j]==min && array4[i][j]>0) {
							q_x.add(i);
							q_y.add(j);
							array[i][j] = 9;
							val = array4[i][j];
							array4[i][j] = 0;
							break forout;
						}
					}
				}
			}
			
			gas -= min;
			if(gas<0) {
				gas = -1;
				break;
			}
			array[x][y] = 0;
			array2 = new int[N+1][N+1];
			marked = new boolean[N+1][N+1];

			go(-val);
			q_x.clear();
			q_y.clear();
			if(min==-1000) {
				gas = -1;
				break;
			}
			gas -= array2[e_x][e_y];
			if(gas<0) {
				gas = -1;
				break;
			}
			q_x.add(e_x);
			q_y.add(e_y);
			gas += 2*array2[e_x][e_y];
			count++;
			array2 = new int[N+1][N+1];
			marked = new boolean[N+1][N+1];
		}
		System.out.println(gas);
	}
	
	static void find() {
		while(!q_x.isEmpty()) {
			int x = q_x.poll();
			int y = q_y.poll();
			marked[x][y] = true;
			if(array2[x][y]>gas) {
				min = -2;
				return;
			}
			if(array4[x][y]>0 && min==Integer.MAX_VALUE) {
				min = -1;
				return;
			}
			if(array2[x][y]>min && min!=Integer.MAX_VALUE) return;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N || array[temp_x][temp_y] == 1) continue;
				if(!marked[temp_x][temp_y]) {
					marked[temp_x][temp_y] = true;
					array2[temp_x][temp_y] = array2[x][y]+1;
					q_x.add(temp_x);
					q_y.add(temp_y);
					if(array4[temp_x][temp_y]>0) {
						min = min<array2[temp_x][temp_y]?min:array2[temp_x][temp_y];
					}
				}
				
			}
		}
	}
	static void go(int a) {
		while(!q_x.isEmpty()) {
			int x = q_x.poll();
			int y = q_y.poll();
			marked[x][y] = true;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N || array[temp_x][temp_y] == 1) continue;
				if(array4[temp_x][temp_y]>0 && !marked[temp_x][temp_y] && array3[-a][temp_x][temp_y]==a) {
					e_x = temp_x;
					e_y = temp_y;
					array2[temp_x][temp_y] = array2[x][y]+1;
					marked[temp_x][temp_y] = true;
					return;
				}
				else if(!marked[temp_x][temp_y]) {
					marked[temp_x][temp_y] = true;
					array2[temp_x][temp_y] = array2[x][y]+1;
					q_x.add(temp_x);
					q_y.add(temp_y);
					if(array3[-a][temp_x][temp_y]==a) {
						e_x = temp_x;
						e_y = temp_y;
						return;
					}
				}
				
			}
		}
		min = -1000;
	}

}
