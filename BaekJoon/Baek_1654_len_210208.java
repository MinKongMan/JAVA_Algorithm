import java.util.Arrays;
import java.util.Scanner;

public class Baek_1654_len_210208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int array[] = new int[N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		long left = 1;
		long right = array[N];
		long mid = 0;
		long value = 0;
		while(left<=right) {
			mid = (left+right)/2;
			value = 0;
			for(int i = 1; i<=N; i++) {
				value += array[i]/mid;
			}
			if(value>M) {
				left = mid+1;
			}
			else if(value<M) {
				right = mid-1;
			}
			else if(value==M) {
				break;
			}
		}
		while(value==M) {
			System.out.println(mid);
			mid++;
			value = 0;
			for(int i = 1; i<=N; i++) {
				value += array[i]/mid;
			}
		}
		System.out.println(mid-1);
		
	}
}
