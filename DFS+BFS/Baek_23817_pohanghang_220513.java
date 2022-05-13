import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_23817_pohanghang_220513 {
	static class xy{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[][] val;
	static int[] per = new int[6];;
	static int count;
	static boolean[] check;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][M+1];
		count = 2;
		ArrayList<xy>[] ar = new ArrayList[22];
		check = new boolean[22];
		for(int i = 1; i<=21; i++) {
			ar[i] = new ArrayList<xy>();
		}
		
		val = new int[22][22];
		for(int i = 1; i<=21; i++) {
			Arrays.fill(val[i], 10000000);
		}
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				if(l.charAt(j-1)=='S') {
					array[i][j] = 1;
					ar[1].add(new xy(i,j));
				}
				else if(l.charAt(j-1)=='K') {
					array[i][j] = count;
					ar[count].add(new xy(i,j));
					count++;
				}
				else if(l.charAt(j-1)=='X') {
					array[i][j] = 101;
				}
			}
		}
		
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		
		for(int i = 1; i<count; i++) {
			Queue<xy> q = new LinkedList<xy>();
			boolean[][] marked = new boolean[N+1][M+1];
			int a = ar[i].get(0).x;
			int b = ar[i].get(0).y;
			q.add(new xy(a,b));
			Queue<Integer> qc = new LinkedList<Integer>();
			marked[a][b] = true;
			qc.add(1);
			
			
			while(!q.isEmpty()) {
				xy node = q.poll();
				int x = node.x;
				int y = node.y;
				int c = qc.poll();
				for(int j = 0; j<4; j++) {
					int temp_x = x+dx[j];
					int temp_y = y+dy[j];
					
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y]==101) continue;
					if(marked[temp_x][temp_y]) continue;
					if(array[temp_x][temp_y]!=0) {
						val[i][array[temp_x][temp_y]] = c;
					}
					marked[temp_x][temp_y] = true;
					q.add(new xy(temp_x,temp_y));
					qc.add(c+1);
				}
			}
		}
		per[0] = 1;
//		for(int i = 1; i<count; i++) {
//			for(int j = 1; j<count; j++) {
//				System.out.print(val[i][j]+" ");
//			}
//			System.out.println();
//		}
		dfs(1);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(min);
	}
	
	static void dfs(int x) {
		if(x==6) {
			int temp_val = 0;
			for(int i = 0; i<5; i++) {
				if(val[per[i]][per[i+1]]==10000000) return;
				else temp_val += val[per[i]][per[i+1]];
			}
			min = min<temp_val?min:temp_val;
			return;
		}
		
		for(int i = 2; i<count; i++) {
			if(check[i]) continue;
			check[i] = true;
			per[x] = i;
			dfs(x+1);
			check[i] = false;
		}
	}

}
