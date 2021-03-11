import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10971_TSP_210311 {
	static int N,temp = 0, min = Integer.MAX_VALUE;
	static boolean[] marked;
	static int[][] array;
	static int[] array2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		marked = new boolean[N+1];
		array2 = new int[N+1];
		StringTokenizer st;
		for(int i= 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j= 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(2,1);
		System.out.println(min);
	}
	static void DFS(int a, int b) {
		if(b==N+1) {
			temp = 0;
			int k = N;
			for(int i = 1; i<N; i++) {
				
				if(array2[i]==0) k = i-1;
				temp += array[array2[i]][array2[i+1]];
			}
			temp += array[array2[k]][array2[1]];
			min = min<temp?min:temp;
			return;
		}
		for(int i = 1; i<=N; i++) {
			if(marked[i] == false) {
				if(a!=i && array[a][i]!=0) {
					marked[i] = true;
					array2[b] = i;
					DFS(i,b+1);
					marked[i] = false;
				}
			}
		}
	}
}
