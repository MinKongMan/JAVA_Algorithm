import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17265_math_220428 {
	static int N;
	static int[] dx = {0,1}, dy = {1,0};
	static char[][] array;
	static int[][] temp;
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		array = new char[N+1][N+1];
		temp = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				char a = st.nextToken().charAt(0);
				temp[i][j] = -1;
				if(a-'0'>=0 && a-'0'<=5) temp[i][j] = a-'0';
				array[i][j] = a;
			}
		}
//		for(int i = 1; i<=5; i++) {
//			for(int j = 1; j<=5; j++) {
//				System.out.print(temp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		dfs(1,1,'0',array[1][1]-'0');
		System.out.println(max+" "+min);
	}
	
	static void dfs(int a, int b, char c, int val) {
		if(temp[a][b]>=0  && temp[a][b]<=5) {
			if(c=='*') {
				val = val*temp[a][b];
			}
			else if(c=='-') {
				val = val-temp[a][b];
			}
			else if(c=='+') {
				val = val+temp[a][b];
			}
		}
//		System.out.println(a+" "+b+" / "+val);
		if(a==N && b==N) {
//			System.out.println(val+" / "+max+" "+min);
			max = max>val?max:val;
			min = min<val?min:val;
		}
		for(int i = 0; i<2; i++) {
			int temp_x = a+dx[i];
			int temp_y = b+dy[i];
			if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
			if(array[temp_x][temp_y]=='+' || array[temp_x][temp_y]=='*' || array[temp_x][temp_y]=='-') {
				dfs(temp_x, temp_y, array[temp_x][temp_y], val);
			}
			else dfs(temp_x, temp_y, c, val);
		}
	}

}
