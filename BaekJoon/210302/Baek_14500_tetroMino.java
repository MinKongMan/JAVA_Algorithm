import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14500_tetroMino {
	static int N,M, max = 0, temp = 0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] marked;
	static int[][] array;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		array = new int[N+5][M+5];
		marked = new boolean[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j= 1; j<=M; j++) {
				m1(i,j);
				temp = array[i][j];
				marked[i][j]=true;
//				System.out.println("謝ル 殮溘:"+" "+i+" "+j);
				dfs(i,j,1);
				marked[i][j]=false;
			}
		}
		System.out.println(max);
	}
	static void m1(int a, int b) {
		temp = array[a][b]+array[a-1][b]+array[a+1][b]+array[a][b+1];//凶
		max = max>temp?max:temp;
		temp = array[a][b]+array[a][b-1]+array[a][b+1]+array[a+1][b];//厄
		max = max>temp?max:temp;
		temp = array[a][b]+array[a-1][b]+array[a+1][b]+array[a][b-1];//勻
		max = max>temp?max:temp;
		temp = array[a][b-1]+array[a][b+1]+array[a][b]+array[a-1][b];//匹
		max = max>temp?max:temp;
	}
	static void dfs(int a, int b, int c) {
		if(c==4) {
			max = max>temp?max:temp;
//			System.out.println(temp+"天天天天天天天天天天天天天天天"+max);
			return;
		}
		for(int i = 0; i<4; i++) {
			int x = a+dx[i];
			int y = b+dy[i];
			if(x<=0||y<=0 || x>N || y>M) continue;
			if(marked[x][y]==false) {
				temp += array[x][y];
				marked[x][y]=true;
//				System.out.println(temp+" "+a+" "+b+" "+x+" "+y);
				dfs(x,y,c+1);
				marked[x][y] = false;
				temp -= array[x][y];
			}
		}
	}
}
