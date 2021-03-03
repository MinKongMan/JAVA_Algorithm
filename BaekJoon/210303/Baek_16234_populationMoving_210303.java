import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
class link{
	int x;
	int y;
	link(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Baek_16234_populationMoving_210303 {
	static int N,L,R,temp = 0, count = 0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static LinkedList<link> link;
	static boolean check;
	static int[][] array;
	static boolean[][] marked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		L = Integer.parseInt(k[1]);
		R = Integer.parseInt(k[2]);
		array = new int[N+1][N+1];
		marked = new boolean[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check = true;
		while(check) {
			link = new LinkedList<link>();
			temp = 0;
			check = false;
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					temp = 0;
					link = new LinkedList<link>();
					dfs(i,j);
					if(link.size()>1) {
						check = true;
						for(int l = 0; l<link.size(); l++) {
						array[link.get(l).x][link.get(l).y] = temp/link.size(); 
						}
					}
				}
			}
			if(check) {
				count++;
			}
			else {
				break;
			}
			marked = new boolean[N+1][N+1];
		}
		System.out.println(count);
	}
	static void dfs(int a,int b) {
		if(a>N||b>N||a<1||b<1|| marked[a][b] == true) {
			return;
		}
		temp += array[a][b];
		link.add(new link(a,b));
		marked[a][b] = true;
		for(int t = 0; t<4; t++) {
			int temp_x = a+dx[t];
			int temp_y = b+dy[t];
			if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
			int k = Math.abs(array[a][b]-array[temp_x][temp_y]);
			if(k>=L && k<=R) dfs(temp_x,temp_y);
		}
	}

}
