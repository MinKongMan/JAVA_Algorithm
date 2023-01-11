import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10836_queenBee_230111 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] array = new int[N+1][N+1];
		int[][] val = new int[M+1][4];

		for(int j = 1; j<=N; j++) {
			for(int i = 1; i<=N; i++) {
				array[i][j] = 1;
			}
		}
		
		for(int n = 1; n <= M; n++) {
			st = new StringTokenizer(br.readLine(), " "); 
			int zero = Integer.parseInt(st.nextToken()); 
			int one = Integer.parseInt(st.nextToken()); 
			int two = Integer.parseInt(st.nextToken()); 

			// 力老 哭率 凯 局国饭 虐快扁 
			for(int i = N; i >= 1; i--) { 
				if(zero != 0) {
					zero--;
				} else if(one != 0) {
					one--;
					array[i][1] += 1;
				} else if(two != 0) {
					two--;
					array[i][1] += 2;
				}
			}
//			System.out.println(zero+" "+one+" "+two);
			// 力老 困率 青 局国饭 虐快扁 
			for(int i = 2; i <= N; i++) {
				if(zero != 0) {
					zero--;
				} else if(one != 0) {
					one--;
					array[1][i] += 1;
				} else if(two != 0) {
					two--;
					array[1][i] += 2;
				}
			}
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=N; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
		}
		
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=N; j++) {
//				System.out.print(array[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for(int i = 2; i<=N; i++) {
			for(int j = 2; j<=N; j++) {
				int x1 = array[i-1][j-1];
				int x2 = array[i-1][j];
				int x3 = array[i][j-1];
				
				int max = Math.max(x1, x2);
				max = Math.max(max, x3);
				array[i][j] = Math.max(max,array[i][j]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				sb.append(array[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
