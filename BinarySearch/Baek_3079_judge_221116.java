import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_3079_judge_221116 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int[] array = new int[N+1];
		
		long max = 0;
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, array[i]);
		}
		
		long l = 0;
		long r = 1000000000*(long)max;
		while(l<r) {
			long mid = (l+r)/2;
			
			long count = 0;
			
			for(int i = 1; i<=N; i++) {
				count += mid/array[i];
			}
			
			if(count>=M) r = mid;
			else l = mid+1;
		}
		System.out.println(l);
	}

}
