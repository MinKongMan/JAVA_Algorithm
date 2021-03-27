import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Baek_3020_fireFly_210327 {
	static int N,M,min;
	static Integer[] array,array2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		min = Integer.MAX_VALUE;
		int[] high = new int[M+1];
		array = new Integer[(N/2)];
		array2 = new Integer[(N/2)];
		for(int i = 0; i<N/2; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			array[i] = a;
			array2[i] = M-b;
		}
		Arrays.sort(array);
		Arrays.sort(array2,Collections.reverseOrder());
		for(int i = 1; i<=M; i++) {
			int bot = binary1(i);
			int top = binary2(i);
			high[i] = bot+top;
			min = min<high[i]?min:high[i];
		}
		
		int count = 0;
		for(int i =1; i<=M; i++) {
			if(high[i]==min) count++;
		}
		
		System.out.println(min +" "+count);
	}
	
	static int binary1(int a) {
		int left = 0;
		int right = (N/2)-1;
		int hyo = Integer.MAX_VALUE;
		while(left<=right) {
			int mid = (left+right)/2;
			if(array[mid]<a) {
				left = mid+1;
			}
			else if(array[mid]>=a) {
				hyo = hyo<mid?hyo:mid;
				right = mid-1;
			}
		}
		if(hyo==Integer.MAX_VALUE) return 0;
		return N/2-hyo;
	}
	
	static int binary2(int a) {
		int left = 0;
		int right = (N/2)-1;
		int hyo = Integer.MAX_VALUE;
		while(left<=right) {
			int mid = (left+right)/2;
			if(array2[mid]<a) {
				right = mid-1;
				hyo = hyo<mid?hyo:mid;
			}
			else if(array2[mid]>=a) {
				left = mid+1;
			}
		}
		if(hyo==Integer.MAX_VALUE) return 0;
		return N/2-hyo;
	}

}
