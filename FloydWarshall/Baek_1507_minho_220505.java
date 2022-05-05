import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1507_minho_220505 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N,M,K;
		N = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][N+1];
		int[][] ar = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				ar[i][j] = array[i][j];
			}
		}
		
		int val = 0;
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				for(int  k = 1; k<=N; k++) {
					if(j==k) continue;
					if(array[j][i]==0 || array[i][k]==0) continue;
					if(ar[j][k]==array[j][i]+array[i][k]) {
//						System.out.println(j+" "+k+" / "+i);
						ar[j][k] = 0;
					}
					else if(ar[j][k]>array[j][i]+array[i][k]) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
//				if(i==j) continue;
//				if(ar[i][j]==0) {
//					System.out.println(-1);
//					return;
//				}
//				System.out.print(ar[i][j]+" ");
				val += ar[i][j];
			}
//			System.out.println();
		}
		
		System.out.println(val/2);
	}

}
