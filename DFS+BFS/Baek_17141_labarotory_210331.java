import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_17141_labarotory_210331 {
	static class b_17141{
		int x;
		int y;
		b_17141(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N,M,K,temp,min = Integer.MAX_VALUE, count, zero = 0;
	static int[][] array, array2;
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();
	static boolean[][] marked;
	static boolean[] check;
	static LinkedList<b_17141>[] link;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		array = new int[N+1][N+1];
		array2 = new int[N+1][N+1];
		marked = new boolean[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j]==2) {
					qx.add(i);
					qy.add(j);
				}
				if(array[i][j]!=1) {
					zero++;
				}
			}
		}
		K = qx.size();
		link = new LinkedList[K+1];
//		System.out.println(K);
		check = new boolean[K+1];
		for(int i = 1; i<=K; i++) {
			link[i] = new LinkedList<>();
			link[i].add(new b_17141(qx.poll(), qy.poll()));
		}
		find(1,1);
		System.out.println(min==Integer.MAX_VALUE?"-1":min);
	}
	static void find(int a, int b) {
		if(a==M+1) {
			marked = new boolean[N+1][N+1];
			array2 = new int[N+1][N+1];
			count = 0;
			temp = 0;
			for(int i = 1; i<=K; i++) {
				if(check[i]) {
					qx.add(link[i].get(0).x);
					qy.add(link[i].get(0).y);
					marked[link[i].get(0).x][link[i].get(0).y]= true; 
//					System.out.print(i+" ");
				}
			}
//			System.out.println();
			BFS();
//			System.out.println(count+" "+(zero-M));
			if(count==zero-M) {
				min = min<temp?min:temp;
//				for(int i = 1; i<=N; i++) {
//					for(int j = 1; j<=N; j++) {
//						System.out.print(array2[i][j]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println(min);
			}
			return;
		}
		
		for(int i = b; i<=K; i++) {
			if(!check[i]) {
				check[i] = true;
				find(a+1,i+1);
				check[i] = false;
			}
		}
	}
	
	static void BFS() {
		while(!qx.isEmpty()) {
			int x= qx.poll();
			int y = qy.poll();
			marked[x][y] = true;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N || array[temp_x][temp_y]==1) continue;
				if(!marked[temp_x][temp_y]) {
					marked[temp_x][temp_y] = true;
//					System.out.println(temp_x+" "+temp_y+" Ä§¹ü?");
					array2[temp_x][temp_y] = array2[x][y]+1;
					count++;
					temp = temp>array2[temp_x][temp_y]?temp:array2[temp_x][temp_y];
					qx.add(temp_x);
					qy.add(temp_y);
				}
			}
		}
//		System.out.println(count+" "+zero+" "+M);
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=N; j++) {
//				System.out.print(array2[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println(min);
	}
}
