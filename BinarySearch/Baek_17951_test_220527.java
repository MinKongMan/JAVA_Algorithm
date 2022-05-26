import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Baek_17951_test_220527 {

	static int N,M;
	static int[] temp_array;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1];
		temp_array = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i =1 ; i<=N; i++) {
			int x = Integer.parseInt(st.nextToken());
			array[i] = x;
			temp_array[i] = array[i]+temp_array[i-1];
		}
		
		int right = temp_array[N];
		int left = temp_array[1];
		
		while(left<right) {
			int mid = (left+right)/2;
			int count = 0;
			int val = 0;
			for(int i = 1; i<=N; i++) {
				val += array[i];
				if(val>mid) {
					count++;
					val = 0;
				}
			}
			if(count>=M) left = mid+1;
			else right = mid;
		}
		System.out.println(left);
	}

}
