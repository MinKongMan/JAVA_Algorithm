import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14890_runWay_210322 {
	static int N,M,max = 0;
	static int[][] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		array = new int[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i<=N; i++) {
			row(i,1);
			column(1,i);
		}
		System.out.println(max);
	}
	
	static void row(int a, int b) {
		int temp = M;
		max++;
		boolean[] marked = new boolean[N+1];
		for(int i = b; i<N; i++) {
			if(Math.abs(array[a][i]-array[a][i+1])>1) {
				max--;
				return;
			}
			else if(array[a][i]==array[a][i+1]) {
				continue;
			}
			else if(array[a][i]-array[a][i+1]==1) {
				if(i+temp>N) {
					max--;
					return;
				}
				for(int j = i+1; j<=i+temp; j++) {
					if(marked[j]) {
						max--;
						return;
					}
					if(j!=i+temp) {
						if(array[a][j]!=array[a][j+1]) {
							max--;
							return;
						}
					}
					marked[j] = true;
				}
			}
			else if(array[a][i]-array[a][i+1]==-1) {
				if(i-temp<0) {
					max--;
					return;
				}
				for(int j = i; j>i-temp; j--) {
					if(marked[j]) {
						max--;
						return;
					}
					if(j!=i-temp+1) {
						if(array[a][j]!=array[a][j-1]) {
							max--;
							return;
						}
					}
					marked[j] = true;
				}
			}
		}
	}
	
	static void column(int a, int b) {
		int temp = M;
		max++;
		boolean[] marked = new boolean[N+1];
		for(int i = a; i<N; i++) {
			if(Math.abs(array[i][b]-array[i+1][b])>1) {
				max--;
				break;
			}
			else if(array[i][b]==array[i+1][b]) {
				continue;
			}
			else if(array[i][b]-array[i+1][b]==1) {
				if(i+temp>N) {
					max--;
					return;
				}
				for(int j = i+1; j<=i+temp; j++) {
					if(marked[j]) {
						max--;
						return;
					}
					if(j!=i+temp) {
						if(array[j][b]!=array[j+1][b]) {
							max--;
							return;
						}
					}
					marked[j] = true;
				}
			}
			else if(array[i][b]-array[i+1][b]==-1) {
				if(i-temp<0) {
					max--;
					return;
				}
				for(int j = i; j>i-temp; j--) {
					if(marked[j]) {
						max--;
						return;
					}
					if(j!=i-temp+1) {
						if(array[j][b]!=array[j-1][b]) {
							max--;
							return;
						}
					}
					marked[j] = true;
				}
			}
		}
	}

}
