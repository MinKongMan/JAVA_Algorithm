import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_15644_ball_220425 {
	static class xy{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][M+1];
		boolean[][][][] marked = new boolean[N+1][M+1][N+1][M+1];
		
		Queue<xy> redq = new LinkedList<xy>();
		Queue<xy> blueq = new LinkedList<xy>();
		Queue<Integer> qc = new LinkedList<>();
		Queue<String> str = new LinkedList<>();
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				if(l.charAt(j-1)=='B') {
					blueq.add(new xy(i,j));
				}
				else if(l.charAt(j-1)=='R') {
					redq.add(new xy(i,j));
				}
				else if(l.charAt(j-1)=='#') {
					array[i][j] = 1;
				}
				else if(l.charAt(j-1)=='O') {
					array[i][j] = 9;
				}
			}
		}
		
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		
		qc.add(0);
		str.add("");
		
		while(!redq.isEmpty()) {
			xy red = redq.poll();
			xy blue = blueq.poll();
			
			int count = qc.poll();
			String l = str.poll();
			if(count>10) {
				System.out.println(-1);
				return;
			}
			if(array[red.x][red.y]==9) {
				System.out.println(count);
				System.out.println(l);
				return;
			}
			if(array[blue.x][blue.y]==9) continue;
			for(int i = 0; i<4; i++) {
				int red_x = red.x+dx[i];
				int red_y = red.y+dy[i];
				while(true) {
					if(red_x<1 || red_y<1 || red_x>N || red_y>M || array[red_x][red_y]==1) {
						red_x -= dx[i];
						red_y -= dy[i];
						break;
					}
					if(array[red_x][red_y]==9) break;
					red_x += dx[i];
					red_y += dy[i];
				}
				
				int blue_x = blue.x+dx[i];
				int blue_y = blue.y+dy[i];
				
				while(true) {
					if(blue_x<1 || blue_y<1 || blue_x>N || blue_y>M || array[blue_x][blue_y]==1) {
						blue_x -= dx[i];
						blue_y -= dy[i];
						break;
					}
					if(array[blue_x][blue_y]==9) break;
					blue_x += dx[i];
					blue_y += dy[i];
				}
				
				if(red_x==blue_x && red_y==blue_y) {
					if(array[red_x][red_y]==9) continue;
					if(i==0) {
						if(red.x<blue.x) blue_x -= dx[i];
						else red_x -= dx[i];
					}
					else if(i==1) {
						if(red.y<blue.y) red_y -= dy[i];
						else blue_y -= dy[i];
					}
					else if(i==2) {
						if(red.x>blue.x) blue_x -= dx[i];
						else red_x -= dx[i];
					}
					else if(i==3) {
						if(red.y<blue.y) blue_y -= dy[i];
						else red_y -= dy[i];
					}
				}
				
				if(marked[red_x][red_y][blue_x][blue_y]) continue;
				marked[red_x][red_y][blue_x][blue_y] = true;
				
				redq.add(new xy(red_x,red_y));
				blueq.add(new xy(blue_x,blue_y));
				qc.add(count+1);
				if(i==0) {
					str.add(l+'U');
				}
				else if(i==1) {
					str.add(l+'R');
				}
				else if(i==2) {
					str.add(l+'D');
				}
				else if(i==3) {
					str.add(l+'L');
				}
				
				
			}
		}
		System.out.println(-1);
		
	}

}
