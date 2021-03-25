import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
class B_2933 implements Comparable<B_2933>{
	int x;
	int y;
	int count;
	B_2933(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(B_2933 arg0) {
		return arg0.x-this.x;
	}
	
}
public class Baek_2933_mineral_210325 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static Queue<Integer> q_x = new LinkedList<Integer>();
	static Queue<Integer> q_y = new LinkedList<Integer>();
	static Queue<Integer> q_z = new LinkedList<Integer>();
	static PriorityQueue<B_2933> fx = new PriorityQueue<B_2933>();
	static int N,M,K,hyojung = 0;
	static int[][] array;
	static int[] t;
	static boolean[][] marked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		marked = new boolean[N+1][M+1];
		array = new int[N+1][M+1];
		String l = "";
		for(int i = 1; i<=N; i++) {
			l = br.readLine();
			for(int j = 1; j<=M; j++) {
				if(l.charAt(j-1)=='.') {
					array[i][j] = 0;
				}
				else if(l.charAt(j-1)=='x') {
					array[i][j] = 1;
				}
			}
		}
//		System.out.println();
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(array[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("문제 시작");
		K = Integer.parseInt(br.readLine());
		t = new int[K+1];
		k = br.readLine().split(" ");
		for(int i = 1; i<=K; i++) {
			hyojung = 0;
			marked = new boolean[N+1][M+1];
			t[i] = Integer.parseInt(k[i-1]);
			fight(N+1-t[i],i%2);
			for(int j = 1; j<=M; j++) {
				if(array[N][j]==1 && !marked[N][j]) {
					q_x.add(N);
					q_y.add(j);
					bottom();
				}
			}
			q_x.clear();
			q_y.clear();
			q_z.clear();
			for(int j = N-1; j>=1; j--) {
				for(int m = 1; m<=M; m++) {
					if(array[j][m]==1 && !marked[j][m]) {
						q_x.add(j);
						q_y.add(m);
						q_z.add(0);
					}
				}
			}
			fall();
			while(!q_x.isEmpty()) {
				fx.add(new B_2933(q_x.poll(), q_y.poll(), hyojung));
			}
			while(!fx.isEmpty()){
				B_2933 hyo = fx.poll();
				int x = hyo.x;
				int y = hyo.y;
				int z = hyojung;
				array[x+z][y] = 1;
				array[x][y] = 0;
			}
//			for(int b = 1; b<=N; b++) {
//				for(int j = 1; j<=M; j++) {
//					System.out.print(array[b][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array[i][j]==1) {
					sb.append('x');
				}
				else if(array[i][j]==0) {
					sb.append('.');
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void fight(int a, int b) {
		if(b==1) {
			for(int i = 1; i<=M; i++) {
				if(array[a][i]==1) {
					array[a][i] = 0;
					return;
				}
			}
		}
		else if(b==0) {
			for(int i = M; i>=1; i--) {
				if(array[a][i]==1) {
					array[a][i] = 0;
					return;
				}
			}
		}
	}
	
	static void bottom() {
		while(!q_x.isEmpty()) {
			int x = q_x.poll();
			int y = q_y.poll();
			marked[x][y] = true;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || marked[temp_x][temp_y] || array[temp_x][temp_y]==0) continue;
				if(array[temp_x][temp_y]==1) {
					marked[temp_x][temp_y] = true;
					q_x.add(temp_x);
					q_y.add(temp_y);
				}
			}
		}
	}
	
	static void fall() {
		while(!q_x.isEmpty()) {
			int x = q_x.poll();
			int y = q_y.poll();
			int count = q_z.poll();
			if(x+count >= N) {
				hyojung = count;
				q_x.add(x);
				q_y.add(y);
				q_z.add(count);
				return;
			}
			if(marked[x+count+1][y] ) {
				hyojung = count;
				q_x.add(x);
				q_y.add(y);
				q_z.add(count);
				return;
			}
			q_x.add(x);
			q_y.add(y);
			q_z.add(count+1);
		}
	}
	

}
