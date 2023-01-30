import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_9084_coin_230130 {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] array = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int[][] table = new int[N+1][M+1];
			
			Arrays.sort(array);
			
			for(int i = 1; i<=M; i++) {
				if(i%array[1]==0) table[1][i] = 1;
			}
			
			for(int i = 2; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					table[i][j] += table[i-1][j];
					if(j+array[i]<=M) {
						table[i][j+array[i]] += table[i][j];
					}
					if(j%array[i]==0) table[i][j]++;
				}
			}
			
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=M; j++) {
//					System.out.print(table[i][j]+" ");
//				}
//				System.out.println();
//			}
			sb.append(table[N][M]+"\n");
		}
		System.out.println(sb);
	}

}
