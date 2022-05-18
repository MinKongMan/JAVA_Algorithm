import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_20159_taza_220519 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] a = new long[N/2+1];
		long[] b = new long[N/2+1];
		
		int count = 1;
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		
		for(int i = 1; i<=N; i++) {
			if(i%2==1) {
				a[count] = a[count-1]+Integer.parseInt(st.nextToken());
			}
			else {
				b[count] = b[count-1]+Integer.parseInt(st.nextToken());
				count++;
			}
		}
		
		long max = 0;
		sum = a[N/2]+b[N/2];
		
		for(int i = 0; i<=N/2; i++) {
			long val1 = a[i]+b[N/2]-b[i];
			long val2 = 0;
			if(i==0) val2 = 0;
			else {
				val2 = a[i]+b[N/2-1]-b[i-1];
			}
//			System.out.println(val1+" "+val2);
			long temp = Math.max(val1, val2);
			max = Math.max(temp,max);
		}
		
		System.out.println(max);
	}

}
