import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_4179_fire_230228 {
	static class xy{
		int x;
		int y;
		char t;
		xy(int x, int y, char t){
			this.x = x;
			this.y = y;
			this.t = t;
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int px = 0;
		int py = 0;
		
		LinkedList<xy> link = new LinkedList<xy>();
		
		int[][] array = new int[N+1][M+1];
		int[][] answer = new int[N+1][M+1];
		boolean[][] fmarked = new boolean[N+1][M+1];
		boolean[][] pmarked = new boolean[N+1][M+1];
		
		Queue<xy> q = new LinkedList<xy>();
		Queue<Integer> qc = new LinkedList<>();
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				answer[i][j] = Integer.MAX_VALUE;
				if(l.charAt(j-1)=='F') {
					array[i][j] = 9;
					q.add(new xy(i,j,'F'));
					qc.add(1);
					fmarked[i][j] = true;
				}
				else if(l.charAt(j-1)=='J') {
					pmarked[i][j] = true;
					array[i][j] = 5;
					answer[i][j] = 0;
					px = i;
					py = j;
				}
				else if(l.charAt(j-1)=='#') array[i][j] = 1;
			}
		}
		q.add(new xy(px,py,'h'));
		qc.add(1);
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		
		if(px == 1 || py == 1 || px==N || py == M) {
			System.out.println(1);
			return;
		}
		
		while(!q.isEmpty()) {
			xy node = q.poll();
			
			int x = node.x;
			int y = node.y;
			int count = qc.poll();
			
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M || array[temp_x][temp_y]==1) continue;
				if(node.t=='F') {
					if(fmarked[temp_x][temp_y]) continue;
					fmarked[temp_x][temp_y] = true;
					q.add(new xy(temp_x,temp_y,'F'));
					qc.add(count+1);
				}
				else {
					if(fmarked[temp_x][temp_y] || pmarked[temp_x][temp_y] || answer[temp_x][temp_y]<=count+1) continue;
					pmarked[temp_x][temp_y] = true;
					answer[temp_x][temp_y] = count+1;
					q.add(new xy(temp_x,temp_y,'p'));
					qc.add(count+1);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(fmarked[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for(int i = 1; i<=N; i++) {
			int temp_min = Math.min(answer[i][1], answer[i][M]);
			min = Math.min(min, temp_min);
		}
		for(int i = 1; i<=M; i++) {
			int temp_min = Math.min(answer[1][i], answer[N][i]);
			min = Math.min(min, temp_min);
		}
		if(min==Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
		else System.out.println(min);
	}

}
