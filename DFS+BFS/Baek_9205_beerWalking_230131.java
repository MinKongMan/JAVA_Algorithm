import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_9205_beerWalking_230131 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for(int tc = 1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int[][] array = new int[N+3][3];
			
			for(int i = 1; i<=N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
			
				array[i][1] = x;
				array[i][2] = y;
			}
			
			boolean[][] marked = new boolean[N+3][N+3];
			
			for(int i = 1; i<=N+2; i++) {
				int x = array[i][1];
				int y = array[i][2];
				for(int j = i+1; j<=N+2; j++) {
					int a = array[j][1];
					int b = array[j][2];
					
					int dis = Math.abs(x-a)+Math.abs(y-b);
					
					if(dis<=1000) {
						marked[i][j] = true;
						marked[j][i] = true;
					}
				}
			}
			
			
			boolean[] check = new boolean[N+3];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1);
			check[1] = true;
			while(!q.isEmpty()) {
				int x = q.poll();
				for(int i = 1; i<=N+2; i++) {
					if(marked[x][i] && !check[i]) {
						check[i] = true;
						q.add(i);
					}
				}
			}
			
			if(check[N+2]) sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb);
	}

}
