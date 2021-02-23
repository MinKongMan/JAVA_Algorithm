import java.util.Scanner;

public class Baek_1987_Alphabet_location_210223 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] array,array2;
	static boolean[] marked = new boolean[26];
	static int N, M, max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		array = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			String b = sc.next();
			for(int j = 1; j<=M; j++) {
				array[i][j] = b.charAt(j-1)-'A';
			}
		}
		DFS(1,1,0);
		System.out.println(max);
	}
	
	static void DFS(int a, int b, int c) {
		if(marked[array[a][b]]) {
			max = max>c?max:c;
			return;
		}
		else {
			for(int i = 0; i<4; i++) {
				int temp_x = a+dx[i];
				int temp_y = b+dy[i];
				if(temp_x>0 && temp_y>0 && temp_x<=N && temp_y<=N) {
					marked[array[a][b]] = true;
					DFS(temp_x,temp_y,c+1);
				}
			}
			marked[array[a][b]] = false;
		}
	}

}
