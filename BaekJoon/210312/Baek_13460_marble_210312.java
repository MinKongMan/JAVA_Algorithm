import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_13460_marble_210312 {
	static class q{
		int rx;
		int ry;
		int bx;
		int by;
		int count;
		q(int rx, int ry, int bx, int by, int count){
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.count = count;
		}
	}
	static int N,M;
	static int[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][][][] marked;
	static Queue<q> q = new LinkedList<q>();
	static int rx,ry,bx,by,cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		array = new int[N+1][M+1];
		marked = new boolean[N+1][M+1][N+1][M+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(),"");
			String l = st.nextToken();
			for(int j = 1; j<=M; j++) {
				if(l.charAt(j-1)=='#') {
					array[i][j] = 1;
				}
				else if(l.charAt(j-1)=='.') {
					array[i][j] = 0;
				}
				else if(l.charAt(j-1)=='R') {
					array[i][j] = 2;
					rx = i;
					ry = j;
				}
				else if(l.charAt(j-1)=='B') {
					array[i][j] = 3;
					bx = i;
					by = j;
				}
				else if(l.charAt(j-1)=='O') {
					array[i][j] = 9;
				}
			}
		}
		marked[rx][ry][bx][by] = true;
		q.add(new q(rx,ry,bx,by,0));
		while(!q.isEmpty()) {
			q temp_q = q.poll();
			if(array[temp_q.bx][temp_q.by]==9) continue;
			if(temp_q.count>10) continue;
			if(array[temp_q.rx][temp_q.ry]==9) {
				cnt = temp_q.count;
				break;
			}
			for(int i = 0; i<4; i++) {
				int x1 = temp_q.rx;
				int y1 = temp_q.ry;
				int x2 = temp_q.bx;
				int y2 = temp_q.by;
				int count = temp_q.count;
				while(true) {
					if(array[x1][y1]!=1 && array[x1][y1]!=9) {
						x1 += dx[i];
						y1 += dy[i];
					}
					else {
						if(array[x1][y1]==1){
							x1 -= dx[i];
							y1 -= dy[i];
						}
						break;
					}
				}
				while(true) {
					if(array[x2][y2]!=1 && array[x2][y2]!=9) {
						x2 +=dx[i];
						y2 += dy[i];
					}
					else {
						if(array[x2][y2] ==1 ){
							x2 -= dx[i];
							y2 -= dy[i];
						}
						break;
					}
				}
				if(x1==x2 && y1==y2 && array[x1][y1]!=9) {
					int r_a = Math.abs(x1-temp_q.rx)+Math.abs((y1-temp_q.ry));
					int b_a = Math.abs(x2-temp_q.bx)+Math.abs((y2-temp_q.by));
					if(r_a>b_a) {
						x1 -= dx[i];
						y1 -= dy[i];
					}
					else {
						x2 -= dx[i];
						y2 -= dy[i];
					}
				}
				if(marked[x1][y1][x2][y2]==false) {
					marked[x1][y1][x2][y2] = true;
					q.add(new q(x1,y1,x2,y2,count+1));
				}
			}
			cnt = -1;
		}
		System.out.println(cnt);
	}

}
