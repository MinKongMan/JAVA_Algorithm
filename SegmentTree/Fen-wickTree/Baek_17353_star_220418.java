import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17353_star_220418 {
	static long[] star;
	static long[] sum,count;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		star = new long[N+1];
		sum = new long[N+1];
		count = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			star[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			
			if(l==1) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				sum(x,1,x);
				sum(y+1,-1,x);
			}
			else {
				int y = Integer.parseInt(st.nextToken());
				sb.append((star[y]+get_val(y))+"\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void sum(int idx, int val, int temp) {
		while(idx<=N) {
			sum[idx] += (temp-1)*val;
			count[idx] += val;
			idx = idx + (idx&-idx);
		}
	}
	
	public static long get_val(int idx) {
		long val = 0;
		int k = idx;
		while(k>=1) {
			val += idx*count[k]-sum[k];
			k = k - (k&-k);
		}
		return val;
	}

}
