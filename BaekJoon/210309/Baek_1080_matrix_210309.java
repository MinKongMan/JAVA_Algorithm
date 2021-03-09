import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1080_matrix_210309 {
	static int temp = 0;
	static int[][] array,array2, array3;
	static int N,M, min = Integer.MAX_VALUE;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		array = new int[N+1][M+1];
		array2 = new int[N+1][M+1];
		array3 = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 0; j<l.length(); j++) {
				array[i][j+1] = l.charAt(j)-'0';
				array3[i][j+1] = array[i][j+1];
			}
		}
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 0; j<l.length(); j++) {
				array2[i][j+1] = l.charAt(j)-'0';
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array[i][j]!=array2[i][j]) {
					if(find(i,j)) temp++;
					else {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(temp);
		
	}
	
	static boolean find(int a, int b) {

		if(a+2>N || b+2>M) return false;
		for(int i = a; i<=(a+2<N?a+2:N); i++) {
			for(int j = b; j<=(b+2<M?b+2:M); j++) {
				if(array[i][j]==0) array[i][j] = 1;
				else array[i][j] = 0;
			}
		}
		return true;
	}
	
	static void choi() {
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				array[i][j] = array3[i][j];
			}
		}
	}

}
