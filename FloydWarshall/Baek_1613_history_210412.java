import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1613_history_210412 {
	static int[][] array;
	static int answer_x, answer_y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		array = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(i==j) array[i][j] = 0;
				else array[i][j] = 100000;
			}
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			array[x][y] = 1;
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				for(int k = 1; k<=N; k++) {
					if(j==k) continue;
					if(array[j][k]>array[j][i]+array[i][k]) {
						array[j][k] = array[j][i]+array[i][k];
					}
				}
			}
		}
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(array[x][y]==100000 && array[y][x]==100000) {
				sb.append("0\n");
			}
			else if(array[x][y]!=100000) sb.append("-1\n");
			else sb.append("1\n");
		}
		System.out.print(sb);
	}
	
}
