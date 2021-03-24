import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class dfs {
	int x;
	int y;
	int c;
	int d;
	dfs(int x, int y, int c, int d){
		this.x = x;
		this.y = y;
		this.c = c;
		this.d = d;
	}
}
public class Baek_1600_mokeyHorse_210324 {
	
	static int N,M,K,min = Integer.MAX_VALUE;
	static int[][] array;
	static int[] dx = {2,1,-1,-2,-2,-1,1,2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	static int[] px = {1,0,-1,0};
	static int[] py = {0,1,0,-1};
	static boolean[][][] marked;
	static Queue<dfs> q = new LinkedList<dfs>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		String[] k = br.readLine().split(" ");
		M = Integer.parseInt(k[0]);
		N = Integer.parseInt(k[1]);
		array = new int[N+1][M+1];
		marked = new boolean[K+1][N+1][M+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<=K; i++) {
			marked[i][1][1] = true;
		}
		q.add(new dfs(1,1,K,0));
		while(!q.isEmpty()) {
			dfs hyo = q.poll();
			int x = hyo.x;
			int y = hyo.y;
			int c = hyo.c;
			int d = hyo.d;
//			System.out.println("출력 시작 ㅡㅡ "+x+" "+y+" "+c+" "+d);
			if(x==N && y==M) {
				min = min<d?min:d;
//				System.out.println("ㅡㅡ최종ㅡㅡㅡ"+d);
//				for(int j = 1; j<=N; j++) {
//					for(int n = 1; n<=M; n++) {
//						if(marked[0][j][n] || marked[1][j][n]) {
//							System.out.print("5"+" ");
//						}
//						else {
//							System.out.print("0"+" ");
//						}
//					}
//					System.out.println();
//				}
//				System.out.println("ㅡㅡㅡ최종ㅡㅡ");
				continue;
			}
			if(c>0) {
				for(int i = 0; i<8; i++) {
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y] == 1) continue;
					if(c-1>=0) {
						if(!marked[c-1][temp_x][temp_y]) {
//							System.out.println(temp_x+" "+temp_y+" "+c);
							q.add(new dfs(temp_x,temp_y,c-1,d+1));
							marked[c-1][temp_x][temp_y] = true;
						}
					}
					
				}
			}
			for(int i = 0; i<4; i++) {
				int temp_x = x+px[i];
				int temp_y = y+py[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y] == 1) continue;
					if(!marked[c][temp_x][temp_y]) {
//						System.out.println(temp_x+" "+temp_y+" "+c+" ㅋㅋ");
						q.add(new dfs(temp_x,temp_y,c,d+1));
						marked[c][temp_x][temp_y] = true;
					}
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? "-1": min);
	}
}
