import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_21758_honey_230220 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N+1];
		int[] right = new int[N+2];
		int[] left = new int[N+2];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=N; i++) {
			right[i] += right[i-1]+array[i];
			left[N-i+1] += left[N-i+2] + array[N-i+1];
		}
		
		int max = 0;
		int sum = array[1];
		for(int i = 2; i<=N; i++) {
			int val = right[N]-array[1]-array[i];
			sum += array[i];
			int val1 = right[N]-sum;
//			System.out.println(i+" "+val+" "+val1+" / "+max);
			max = Math.max(val+val1,max);
			
		}
		
//		System.out.println(max);
		sum = array[N];
		for(int i = N-1; i>=1; i--) {
			int val = left[1] - array[N] - array[i];
			
			sum += array[i];
			int val1 = left[1]-sum;
//			System.out.println(i+" "+val+" "+val1+" / "+max);
			max = Math.max(val+val1, max);
		}
		
		for(int i = 2; i<=N-1; i++) {
			int val = right[i]-array[1];
			
			int val1 = left[i]-array[N];
//			System.out.println(i+" "+val+" "+val1+" / "+max);
			max = Math.max(max, val+val1);
		}
		
		System.out.println(max);
	}

}
