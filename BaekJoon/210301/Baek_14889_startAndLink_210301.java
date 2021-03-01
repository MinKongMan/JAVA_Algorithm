import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14889_startAndLink_210301 {
	static int N;
	static int[][] array;
	static boolean[] marked;
	static int start = 0,link = 0, temp = 0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		marked = new boolean[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		B(1,1);
		System.out.println(min);
		 
	}
	static void B(int a, int b) {
		if(b==(N/2)+1) {
			start = 0;
			link = 0;
			for(int i = 1; i<=N; i++) {
				if(marked[i] == true) {
					for(int j = 1; j<=N; j++) {
						if(marked[j]==true) {
							start+=array[i][j];
						}
					}
				}
				else if(marked[i]==false) {
					for(int j = 1; j<=N; j++) {
						if(marked[j]==false) {
							link+=array[i][j];
						}
					}
				}
			}
			temp = Math.abs(start-link);
			min = min<temp?min:temp;
			return;
		}
		for(int i = a; i<=N; i++) {
			if(marked[i]==false) {
				marked[i] = true;
				B(i+1,b+1);
				marked[i] = false;
			}
		}
	}

}
