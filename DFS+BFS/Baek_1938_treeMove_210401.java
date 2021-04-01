import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_1938_treeMove_210401 {
	static class tree{
		int x;
		int y;
		int state;
		tree(int x, int y, int state){
			this.x = x;
			this.y = y;
			this.state = state;
		}
	}
	static boolean[][][] marked;
	static int N, state;
	static int[][] array;
	static int[][][] array2;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[] dx2 = {-1,-1,0,1,1,1,0,-1};
	static int[] dy2 = {0,1,1,1,0,-1,-1,-1};
	static Queue<tree> q = new LinkedList<tree>();
	static Queue<tree> p = new LinkedList<tree>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		array2 = new int[3][N+1][N+1];
		marked = new boolean[3][N+1][N+1];
		state = 1;
		int count = 0;
		int count1 = 0;
		for(int i = 1; i<=N; i++) {
			String k = br.readLine();
			for(int j = 1; j<=N; j++) {
				if(k.charAt(j-1)=='B') {
					count++;
					array[i][j] = 2;
					if(count==2) {
						q.add(new tree(i,j,0));
					}
				}
				else if(k.charAt(j-1)=='0') {
					array[i][j] = 0;
				}
				else if(k.charAt(j-1)=='1') {
					array[i][j] = 1;
				}
				else if(k.charAt(j-1)=='E') {
					count1++;
					array[i][j] = 9;
					if(count1==2) {
						p.add(new tree(i,j,0));
					}
				}
				if(array[i][j]==2 && array[i][j-1]==2) {
					state = 2;
				}
			}
		}
		for(int i = 1; i<=3; i++) {
			tree k = q.poll();
			q.add(new tree(k.x,k.y,state));
			marked[state][k.x][k.y]= true; 
		}
		while(!q.isEmpty()) {
			tree hyo = q.poll();
			int x = hyo.x;
			int y = hyo.y;
			state = hyo.state;
			boolean flag = true;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N || array[temp_x][temp_y]==1) continue;
				if(state == 1) {
					if(temp_x-1<1 || temp_x+1>N || array[temp_x-1][temp_y]==1 || array[temp_x+1][temp_y]==1) continue;
				}
				else if(state == 2) {
					if(temp_y-1<1 || temp_y+1>N || array[temp_x][temp_y-1]==1 || array[temp_x][temp_y+1]==1) continue;
				}
//				System.out.println(state+" "+temp_x+" "+temp_y);
				if(!marked[state][temp_x][temp_y]) {
					marked[state][temp_x][temp_y] = true;
					array2[state][temp_x][temp_y] = array2[state][x][y]+1;
					q.add(new tree(temp_x,temp_y,state));
				}
			}
			for(int i = 0; i<8; i++) {
				int temp_x = x+dx2[i];
				int temp_y = y+dy2[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) {
					flag = false;
					break;
				}
				if(array[temp_x][temp_y]==1) {
					flag = false;
					break;
				}
			}
			if(flag) {
				if(!marked[(state%2)+1][x][y]) {
					marked[(state%2)+1][x][y] = true;
					array2[(state%2)+1][x][y] = array2[state][x][y]+1;
					q.add(new tree(x,y,(state%2)+1));
				}
			}
		}
		tree jung = p.peek();
		int x = jung.x;
		int y = jung.y;
		if(array2[1][x][y]==0 && array2[2][x][y]==0) {
			System.out.println("0");
		}
		else if(array2[1][x][y]!=0 && array2[2][x][y]!=0){
			int a = array2[1][x][y]<array2[2][x][y]?array2[1][x][y]:array2[2][x][y];
			System.out.println(a);
		}
		else if(array2[1][x][y]==0) {
			System.out.println(array2[2][x][y]);
		}
		else if(array2[2][x][y]==0) {
			System.out.println(array2[1][x][y]);
		}
	}

}
