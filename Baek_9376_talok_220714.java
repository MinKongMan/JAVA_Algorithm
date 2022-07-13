import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_9376_talok_220714 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int val;
		xy(int x, int y, int val){
			this.x =x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
	}
	static boolean[][] marked;
	static int N,M;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static int[][] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int zzz = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int TC = 1; TC<=zzz; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			
			array = new int[N+2][M+2];
			PriorityQueue<xy> q1 = new PriorityQueue<xy>();
			PriorityQueue<xy> q2 = new PriorityQueue<xy>();
			marked = new boolean[N+1][M+1];
			for(int i = 1; i<=N; i++) {
				String l = br.readLine();
				for(int j = 1; j<=M; j++) {
					if(l.charAt(j-1)=='*') array[i][j] = -1;
					else if(l.charAt(j-1)=='#') {
						array[i][j] = -2;
					}
					else if(l.charAt(j-1)=='$') {
						if(q1.isEmpty()) {
							q1.add(new xy(i,j,0));
						}
						else {
							q2.add(new xy(i,j,0));
						}
						array[i][j] = -5;
					}
				}
			}
			
			int[][] array1 = queue(q1);
//			if(TC==1) {
//				for(int i = 0; i<=N+1; i++) {
//					for(int j = 0; j<=M+1; j++) {
//						System.out.print(array1[i][j]);
//					}
//					System.out.println();
//				}
//			}
			int[][] array2 = queue(q2);
			
			PriorityQueue<xy> q = new PriorityQueue<xy>();
			q.add(new xy(0,0,0));
			
			int[][] array3 = queue(q);
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<=N+1; i++) {
				for(int j = 0; j<=M+1; j++) {
					int temp_val = Integer.MAX_VALUE;
					if(array[i][j]==-2) {
						temp_val = array1[i][j]+array2[i][j]+array3[i][j]-2;
					}
					else if(array[i][j]==-1) continue;
					else {
						temp_val = array1[i][j]+array2[i][j]+array3[i][j];
					}
					min = Math.min(min, temp_val);
				}
			}
//			for(int i = 0; i<=N+1; i++) {
//				for(int j = 0; j<=M+1; j++) {
//					System.out.print(array3[i][j]);
//				}
//				System.out.println();
//			}
			sb.append(min+"\n");
		}
		
		System.out.println(sb);
	}
	
	static int[][] queue(PriorityQueue<xy> q){
		int[][] temp_array = new int[N+2][M+2];
		
		for(int i = 0; i<=N+1; i++) {
			for(int j = 0; j<=M+1; j++) {
				temp_array[i][j] = Integer.MAX_VALUE;
				if(array[i][j]==-1) temp_array[i][j] = 1;
			}
		}
		
		
		while(!q.isEmpty()) {
			xy node = q.poll();
			int x = node.x;
			int y = node.y;
//			System.out.println(x+" "+y+" "+temp_array[x][y]+" "+node.val);
			if(temp_array[x][y]<node.val) continue;
			temp_array[x][y] = node.val;
			
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<0 || temp_y<0 || temp_x>N+1 || temp_y>M+1) continue;
				if(array[temp_x][temp_y]==-1) continue;
				if(array[temp_x][temp_y]==-2) {
					if(temp_array[temp_x][temp_y]>temp_array[x][y]+1) {
						temp_array[temp_x][temp_y] = temp_array[x][y]+1;
						q.add(new xy(temp_x,temp_y, temp_array[temp_x][temp_y]));
					}
				}
				else {
					if(temp_array[temp_x][temp_y]>temp_array[x][y]) {
						temp_array[temp_x][temp_y] = temp_array[x][y];
						q.add(new xy(temp_x,temp_y, temp_array[temp_x][temp_y]));
					}
				}
				
			}
		}
		
		return temp_array;
	}
	

}
