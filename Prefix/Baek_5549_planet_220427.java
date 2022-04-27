import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_5549_planet_220427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		int[][] array1 = new int[N+1][M+1];
		int[][] array2 = new int[N+1][M+1];
		int[][] array3 = new int[N+1][M+1];
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			int I = 0, J = 0, O = 0;
			for(int j =1; j<=M; j++) {
				array1[i][j] = array1[i-1][j]+J;
				array2[i][j] = array2[i-1][j]+O;
				array3[i][j] = array3[i-1][j]+I;
				if(l.charAt(j-1)=='J') {
					J++;
					array1[i][j]++;
				}
				else if(l.charAt(j-1)=='O') {
					O++;
					array2[i][j]++;
				}
				else {
					I++;
					array3[i][j]++;
				}
			}
		}
		
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(array1[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("天天天天天天天天天");
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(array2[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("天天天天天天天天天");
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(array3[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("天天天天天天天天天");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int I = 0;
			int O = 0;
			int J = 0;
			J += array1[x2][y2]-array1[x1-1][y2]-array1[x2][y1-1]+array1[x1-1][y1-1];
			O += array2[x2][y2]-array2[x1-1][y2]-array2[x2][y1-1]+array2[x1-1][y1-1];
			I += array3[x2][y2]-array3[x1-1][y2]-array3[x2][y1-1]+array3[x1-1][y1-1];
			sb.append(J+" "+O+" "+I+"\n");
		}
		System.out.println(sb);
	}

}
