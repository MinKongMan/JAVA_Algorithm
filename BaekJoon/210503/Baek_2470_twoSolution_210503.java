import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2470_twoSolution_210503 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		int left = 0;
		int right = N-1;
		int ans1 = array[left];
		int ans2 = array[right];
		int ans = array[left]+array[right];
		while(left<right) {
			int mid = array[left]+array[right];
			if(mid==0) {
				ans1 = array[left];
				ans2 = array[right];
				break;
			}
			else if(mid<0) {
				if(Math.abs(mid)<Math.abs(ans)) {
					ans1 = array[left];
					ans2 = array[right];
					ans = mid;
				}
				left++;
				
			}
			else if(mid>0) {
				if(Math.abs(mid)<Math.abs(ans)) {
					ans1 = array[left];
					ans2 = array[right];
					ans = mid;
				}
				right--;
			}
			
		}
		System.out.println(ans1+" "+ans2);
	}

}
