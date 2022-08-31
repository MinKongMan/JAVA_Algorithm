import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_3151_sum0_220830 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		
		int[] array = new int[N];
		int[] ar = new int[20001];
		
		
		for(int i = 0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		long ans = 0;
		
		for(int i = 0; i<N; i++) {
			int l = i+1;
			int r = N-1;
			int x = array[i];
			while(l<r) {
				int y = array[l];
				int z = array[r];
				if(x+y+z==0) {
					if(y==z) {
						ans += (r-l+1)*(r-l)/2;
						break;
					}
					int count_l = 0;
					while(true) {
						if(l>=N) break;
						if(array[l]!=y) break;
						else {
							count_l++;
							l++;
						}
					}
					
					int count_r = 0;
					while(true) {
						if(r<=i) break;
						if(array[r]!=z) break;
						else {
							count_r++;
							r--;
						}
					}
//					System.out.println(x+" "+y+" "+z+" / "+count_l+" "+count_r);
					ans += (count_l*count_r);
				}
				else if(x+y+z<0) l++;
				else r--;
			}
		}
		
	
		System.out.println(ans);
	}

}
