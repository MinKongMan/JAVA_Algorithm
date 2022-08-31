import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_16920_expansion_220831 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int m;
		int val;
		int count;
		xy(int x, int y, int m, int val, int count){
			this.x = x;
			this.y = y;
			this.val = val;
			this.m = m;
			this.count = count;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			if(this.count==arg0.count) return this.m-arg0.m;
			return this.count-arg0.count;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][M+1];
		int[] t = new int[K+1];
		xy[][] ar = new xy[N+1][M+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=K; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				ar[i][j] = new xy(i,j,0,0,0);
				if(l.charAt(j-1)=='.') array[i][j] = Integer.MAX_VALUE;
				else if(l.charAt(j-1)=='#') array[i][j] = -1;
				else {
					array[i][j] = 0;
					int x = l.charAt(j-1)-'0';
					pq.add(new xy(i,j,x,0,0));
					ar[i][j] = new xy(i,j,x,0,0);
				}
			}
		}
		
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			int idx = node.m;
			int val = node.val;
			int count = node.count;
//			System.out.println(x+" "+y+" "+idx+" "+val);
			Queue<xy> q = new LinkedList<xy>();
			q.add(new xy(x,y,idx,val,count));
			while(!pq.isEmpty()) {
				if(pq.peek().m==idx) q.add(pq.poll());
				else break;
			}
			while(!q.isEmpty()) {
				xy qx = q.poll();
				int tx = qx.x;
				int ty = qx.y;
				for(int i = 0; i<4; i++) {
					int temp_x = tx+dx[i];
					int temp_y = ty+dy[i];
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
					if(array[temp_x][temp_y]==-1) continue;
					if(array[temp_x][temp_y]!=Integer.MAX_VALUE && array[temp_x][temp_y]>=0) continue;
					if(qx.val-val==t[idx]-1) {
						array[temp_x][temp_y] = array[tx][ty]+1;
						pq.add(new xy(temp_x, temp_y, idx, array[temp_x][temp_y],count+1));
					}
					else if(qx.val-val<t[idx]-1) {
						array[temp_x][temp_y] = array[tx][ty]+1;
						q.add(new xy(temp_x,temp_y,idx,array[temp_x][temp_y],count));
					}
//					System.out.println(temp_x+" "+temp_y);
					ar[temp_x][temp_y].m=idx;
					ar[temp_x][temp_y].val=array[temp_x][temp_y];
				}
			}
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=M; j++) {
//					if(array[i][j]==Integer.MAX_VALUE) System.out.print(-5+" ");
//					else System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("天天天天天天天天天天天天天天天天天天");
		}
		int[] answer = new int[K+1];
		for(int i = 1; i<=N; i++) {
			for(int j =1 ; j<=M; j++) {
				answer[ar[i][j].m]++;
			}
		}
//		for(int i = 1; i<=N; i++) {
//			for(int j =1 ; j<=M; j++) {
//				System.out.print(array[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i = 1; i<=K; i++) {
			System.out.print(answer[i]+" ");
		}
	}

}
