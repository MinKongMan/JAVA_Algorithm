import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_17425_sum_220524 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		long[] array = new long[1000001];
		long[] array2 = new long[1000001];
		Arrays.fill(array, 1);
		for(int i = 2; i<=1000000; i++) {
			for(int j = 1; j*i<=1000000; j++) {
				array[j*i] += i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
//		for(int i = 1; i<=36; i++) {
//			System.out.println(array[i]+" / "+i);
//		}
		
		for(int i = 1; i<=1000000; i++) {
			array2[i] = array2[i-1]+array[i];
		}
		
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			
			sb.append((array2[x])+"\n");
		}
		System.out.println(sb);

	}

}
