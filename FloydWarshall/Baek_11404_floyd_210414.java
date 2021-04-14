import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11404_floyd_210414 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N+1][N+1];
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(i==j) array[i][j] = 0;
				else array[i][j] = 100000;
			}
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			array[a][b] = array[a][b]<c? array[a][b]:c;
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				for(int k = 1; k<=N; k++) {
					if(array[j][k]> array[j][i]+array[i][k]) {
						array[j][k] = array[j][i]+array[i][k];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(array[i][j]==100000) System.out.print("0 ");
				else System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}

}
