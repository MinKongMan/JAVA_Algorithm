import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_17472_makeBridge2_210404 {
	static class make{
		int end;
		int val;
		make(int end, int val){
			this.end = end;
			this.val = val;
		}
	}
	static class pq implements Comparable<pq>{
		int start;
		int end;
		int val;
		pq(int start, int end, int val){
			this.start = start;
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(pq arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
	}
	static int N,M, stack = 1, answer = 0;
	static int[][] array,array2;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] val;
	static int[] parent;
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();
	static PriorityQueue<pq> q = new PriorityQueue<pq>();
	static ArrayList<make>[] ar;
	static boolean[][] marked;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		marked = new boolean[N+1][M+1];
		array = new int[N+1][M+1];
		array2 = new int[N+1][M+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array[i][j]  == 1 && !marked[i][j]) {
					array2[i][j] = stack;
					marked[i][j] = true;
					dfs(i,j);
					stack++;
				}
//				System.out.print(array2[i][j]+" ");
			}
//			System.out.println();
		}
		val = new int[stack][stack];
		parent = new int[stack];
		check = new boolean[stack];
		for(int i = 1; i<stack; i++) {
			parent[i] = i;
		}
		for(int i = 1; i<stack; i++) {
			for(int j = 1; j<stack; j++) {
				val[i][j] = Integer.MAX_VALUE;
				if(i==j) val[i][j] = 0;
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array2[i][j]!=0) {
					qx.add(i);
					qy.add(j);
					BFS(array2[i][j]);
				}
			}
		}
		for(int i = 1; i<stack; i++) {
			for(int j = 1; j<stack; j++) {
				if(val[i][j]>0 && val[i][j]!=Integer.MAX_VALUE) {
					q.add(new pq(i,j,val[i][j]));
				}
//				if(val[i][j]==Integer.MAX_VALUE) System.out.print("0 ");
//				else System.out.print(val[i][j]+" ");
			}
//			System.out.println();
		}
		
		while(!q.isEmpty()) {
			pq hyo = q.poll();
			int x = hyo.start;
			int y = hyo.end;
			if(find(x)!=find(y)) {
//				System.out.println(x+" "+y+" / "+find(x)+ " "+find(y)+" / "+answer+" "+hyo.val);
				answer += hyo.val;
				check[x] = true;
				check[y] = true;
				union(x,y);
			}
		}
		boolean flag = true;
		int check_val = find(1);
		for(int i = 1; i<stack; i++) {
			if(find(i)!=check_val || !check[i]) {
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println(answer==0?"-1":answer);
		}
		else System.out.println("-1");
		
	}
	
	static void dfs(int a, int b) {
		for(int i = 0; i<4; i++) {
			int temp_x = a+dx[i];
			int temp_y = b+dy[i];
			if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y]==0) continue;
			if(!marked[temp_x][temp_y]) {
				marked[temp_x][temp_y] = true;
				array2[temp_x][temp_y] = stack;
				dfs(temp_x,temp_y);
			}
		}
	}
	
	static void BFS(int a) {
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				int count = 0;
				while(true) {
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array2[temp_x][temp_y]==a ) break;
					else if(array2[temp_x][temp_y]==0) {
						temp_x +=dx[i];
						temp_y +=dy[i];
						count++;
					}
					else if(array2[temp_x][temp_y]!=0) {
						if(count>1) {
							val[a][array2[temp_x][temp_y]] =
									val[a][array2[temp_x][temp_y]]<val[a][a]+count?val[a][array2[temp_x][temp_y]]:val[a][a]+count;
//									System.out.println(val[a][array2[temp_x][temp_y]]+" "+a+" "+array2[temp_x][temp_y]);
						}
						break;
					}
				}
			}
		}
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		else return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x<y) {
			parent[y] = x;
		}
		else {
			parent[x] = y;
		}
	}
}
