import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1944_robot_220408 {
	static class xy{
		int x;
		int y;
		int m;
		xy(int x, int y, int m){
			this.x = x;
			this.y = y;
			this.m = m;
		}
	}
	
	static class find implements Comparable<find>{
		int x;
		int y;
		int val;
		find(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(find arg0) {
			return this.val-arg0.val;
		}
	}
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<xy>[] ar = new ArrayList[M+1];
		parent = new int[M+1];
		
		for(int i = 0; i<=M; i++) {
			ar[i] = new ArrayList<xy>();
			parent[i] = i;
		}
		
		int[][] array = new int[N+1][N+1];
		int[][] temp_array = new int[N+1][N+1];
		int count = 0;
		PriorityQueue<find> pq = new PriorityQueue<find>();
		
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			Arrays.fill(temp_array[i], -1);
			for(int j = 1; j<=N; j++) {
				if(l.charAt(j-1)=='S') {
					array[i][j] = 9;
					temp_array[i][j] = count;
					ar[count].add(new xy(i,j,0));
					count++;
				}
				else if(l.charAt(j-1)=='K') {
					array[i][j] = 5;
					temp_array[i][j] = count;
					ar[count].add(new xy(i,j,0));
					count++;
				}
				else {
					array[i][j] = l.charAt(j-1)-'0';
				}
			}
		}
		
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};

		int answer = 0;
		
		for(int i = 0; i<=M; i++) {
			int x = ar[i].get(0).x;
			int y = ar[i].get(0).y;
			Queue<xy> q = new LinkedList<>();
			Queue<Integer> qc = new LinkedList<Integer>();
			q.add(new xy(x,y,i));
			qc.add(0);
			
			boolean[][] marked = new boolean[N+1][N+1];
			marked[x][y] = true;
			
			while(!q.isEmpty()) {
				xy temp = q.poll();
				int n = temp.x;
				int m = temp.y;
				int c = qc.poll();
				for(int j = 0; j<4; j++) {
					int temp_x = n+dx[j];
					int temp_y = m+dy[j];
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
					if(marked[temp_x][temp_y] || array[temp_x][temp_y]==1) continue;
					marked[temp_x][temp_y] = true;
					if(temp_array[temp_x][temp_y]!=-1) {
						q.add(new xy(temp_x,temp_y,temp_array[temp_x][temp_y]));
						qc.add(c+1);
						System.out.println(x+" "+y+" / "+temp_x+" "+temp_y+" ");
						pq.add(new find(temp.m,temp_array[temp_x][temp_y],c+1));
					}
					else {
						q.add(new xy(temp_x,temp_y,temp.m));
						qc.add(c+1);
					}
				}
			}
		}
		System.out.println(pq.size());
		if(pq.isEmpty()) {
			System.out.println(-1);
			return;
		}
		while(!pq.isEmpty()) {
			find hyo = pq.poll();
			int x = hyo.x;
			int y = hyo.y;
			System.out.println(x+" "+y+" "+hyo.val);
			if(find(parent[x])!=find(parent[y])) {
				union(x,y);
				answer += hyo.val;
			}
		}
		for(int i = 0; i<=M; i++) {
			if(find(parent[i])!=0) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(answer);
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) {
			parent[b] = a;
		}
		else {
			parent[a] = b;
		}
	}
}
