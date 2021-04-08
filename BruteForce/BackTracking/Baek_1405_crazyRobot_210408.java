import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_1405_crazyRobot_210408 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] marked;
	static double[] array;
	static double answer = 0;
	static int N;
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		array = new double[5];
		marked = new boolean[2*N+2][2*N+2];
		for(int i = 1; i<=4; i++) {
			int a = Integer.parseInt(st.nextToken());
			array[i] = (double)a/100;
		}
		marked[N+1][N+1] = true;
		find(N+1,N+1,0);
		String l = answer+"";
		if(l.length()>11) {
		System.out.println(String.format("%.9f", answer));
		}
		else {
			System.out.println(answer);
		}
	}
	
	static void find(int a, int b, int c) {
		if(c==N) {
			double k = 1;
			for(int i = 0; i<stack.size(); i++) {
				k *= array[stack.get(i)];
			}
			answer += k;
			return;
		}
		for(int i = 0; i<4; i++) {
			int temp_x = a+dx[i];
			int temp_y = b+dy[i];
			if(!marked[temp_x][temp_y]) {
				marked[temp_x][temp_y] = true;
				stack.push(i+1);
				find(temp_x,temp_y,c+1);
				stack.pop();
				marked[temp_x][temp_y] = false;
			}
		}
	}

}
