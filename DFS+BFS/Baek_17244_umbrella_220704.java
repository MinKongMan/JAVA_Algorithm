import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_17244_umbrella_220704 {
	
	static class xy{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[][] array,ar;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1}, ar_node;
	static boolean[][] marked;
	static boolean[] check;
	static int N,M;
	static int min = Integer.MAX_VALUE;
	static LinkedList<xy> link = new LinkedList<xy>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int start_x = 0;
		int start_y = 0;
		int end_x = 0;
		int end_y = 0;
		
		array = new int[N+1][M+1];
		int temp_count = 2;
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				if(l.charAt(j-1)=='#') {
					array[i][j] = -1;
				}
				else if(l.charAt(j-1)=='S') {
					start_x = i;
					start_y = j;
					array[i][j] = 1;
				}
				else if(l.charAt(j-1)=='X') {
					link.add(new xy(i,j));
					array[i][j] = temp_count;
					temp_count++;
				}
				else if(l.charAt(j-1)=='E') {
					end_x = i;
					end_y = j;
				}
			}
		}
		link.add(0, new xy(start_x,start_y));
		link.add(new xy(end_x,end_y));
		array[end_x][end_y] = link.size();
		
		int tc = 1;
		ar_node = new int[link.size()+1];
		ar = new int[link.size()+1][link.size()+1];
		check = new boolean[link.size()+1];
		
		for(xy node : link) {
			marked = new boolean[N+1][M+1];
			Queue<xy> q = new LinkedList<xy>();
			Queue<Integer> qc = new LinkedList<Integer>();
			q.add(node);
			qc.add(0);
			marked[node.x][node.y]= true; 
			while(!q.isEmpty()) {
				xy temp_node = q.poll();
				int x = temp_node.x;
				int y = temp_node.y;
				int count = qc.poll();
				for(int i = 0; i<4; i++) {
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
					if(marked[temp_x][temp_y]) continue;
					if(array[temp_x][temp_y]==-1) continue;
					if(array[temp_x][temp_y]>0) {
//						System.out.println(tc+" "+temp_x+" "+temp_y+" / "+array[temp_x][temp_y]);
						ar[tc][array[temp_x][temp_y]] = count+1;
						ar[array[temp_x][temp_y]][tc] = count+1;
					}
					marked[temp_x][temp_y] = true;
					qc.add(count+1);
					q.add(new xy(temp_x,temp_y));
				}
			}
			tc++;
			
		}
		dfs(1);
		if(link.size()==2) {
			System.out.println(ar[1][2]);
		}
		else System.out.println(min);
		
	}
	
	static void dfs(int x) {
		if(x==link.size()-1) {
			int temp = 0;
//			System.out.println(x);
			temp += ar[1][ar_node[1]];
			for(int i = 1; i<=link.size()-2; i++) {
//				System.out.print(ar_node[i]+" ");
				temp += ar[ar_node[i]][ar_node[i+1]];
			}
			temp += ar[link.size()][ar_node[link.size()-2]];
			min = temp<min?temp:min;
		}
		for(int i = 2; i<link.size(); i++) {
			if(check[i]) continue;
			check[i] = true;
			ar_node[x] = i;
			dfs(x+1);
			check[i] = false;
		}
	}
}
