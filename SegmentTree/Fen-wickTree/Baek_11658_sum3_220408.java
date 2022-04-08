import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11658_sum3_220408 {
	static long[][] Ftree,array;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Ftree = new long[N+1][N+1];
		array = new long[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
			make_FT(i,array[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				long answer = get_FT(x1,y1,x2,y2);
				sb.append(answer+"\n");
			}
			else {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				update_FT(x1,y1,val);
			}
		}
		System.out.println(sb);

	}

	static void make_FT(int x, long[] array) {
		for(int i = 1; i<=N; i++) {
			int idx = i;
			while(idx<=array.length) {
				Ftree[x][idx] += array[i];
				idx = idx+(idx&(-idx));
			}
		}
	}
	
	static void update_FT(int x, int y, long val) {
		int idx = y;
		while(idx<=Ftree[x].length) {
			Ftree[x][idx] += (val-array[x][y]);
			idx = idx + (idx&(-idx));
		}
		array[x][y] = val;
	}
	
	static long get_FT(int x1, int y1, int x2, int y2) {
		long answer = 0;
		for(int i = x1; i<=x2; i++) {
			long sum1 = get(y1-1, i);
			long sum2 = get(y2, i);
			answer += (sum2-sum1);
		}
		return answer;
	}
	
	static long get(int idx, int x) {
		long answer = 0;
		while(idx>0) {
			answer += Ftree[x][idx];
			idx = idx-(idx&(-idx));
		}
		return answer;
	}
}
