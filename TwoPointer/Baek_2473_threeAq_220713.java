import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2473_threeAq_220713 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long[] array = new long[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		long a1 = 0, a2 = 0, a3 = 0;
		long min = Long.MAX_VALUE;
		
		for(int i = 0; i<N; i++) {
			long val = array[i];
			int left = i+1;
			int right = N-1;
			while(left<right) {
				if(val+array[left]+array[right]<0) {
					long temp_val = Math.abs(val+array[left]+array[right]);
					if(temp_val<min) {
						min = temp_val;
						a1 = array[i];
						a2 = array[left];
						a3 = array[right];
					}
					left++;
				}
				else if(val+array[left]+array[right]==0) {
					System.out.println(val+" "+array[left]+" "+array[right]);
					return;
				}
				else {
					long temp_val = Math.abs(val+array[left]+array[right]);
					if(temp_val<min) {
						min = temp_val;
						a1 = array[i];
						a2 = array[left];
						a3 = array[right];
					}
					right--;
				}
			}
		}
		System.out.println(a1+" "+a2+" "+a3);
	}

}
