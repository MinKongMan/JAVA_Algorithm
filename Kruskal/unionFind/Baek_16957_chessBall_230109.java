import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_16957_chessBall_230109 {
	static class xy implements Comparable<xy>{
		int val;
		int x;
		int y;
		
		xy(int val, int x, int y){
			this.val = val;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(xy arg0) {
			return this.val-arg0.val;
		}
	}
	static int[] parent;
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int[][] array = new int[N][M];
		parent = new int[N*M];
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				parent[i*M+j] = i*M+j;
				pq.add(new xy(array[i][j],i,j));
			}
		}
		
		int[][] answer = new int[N][M];
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			
			int x = node.x;
			int y = node.y;
			int val = node.val;
			
			int tx = -1, ty = -1;
			
			for(int i = 0; i<8; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				
				if(temp_x<0 || temp_y<0 || temp_x>=N || temp_y>=M) continue;
				
				if(array[temp_x][temp_y]>array[x][y]) continue;
				
				if(val>array[temp_x][temp_y]) {
					tx = temp_x;
					ty = temp_y;
					val = array[temp_x][temp_y];
				}
			}
			
			if(tx==-1 && ty==-1) answer[x][y]++;
			else {
				union(tx*M+ty,x*M+y);
				int temp_x = parent[x*M+y]/M;
				int temp_y = parent[x*M+y]%M;
				answer[temp_x][temp_y]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				sb.append(answer[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		parent[b] = a;
	}

}
