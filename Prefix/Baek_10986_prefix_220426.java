import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10986_prefix_220426 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] array = new int[M];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		
		for(int i = 1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum = (sum+num)%M;
			array[sum]++;
		}
		
		long val = array[0];
		for(int i = 0; i<M; i++) {
			val += (long)array[i]*(array[i]-1)/2;
		}
		System.out.println(val);
	}

}
