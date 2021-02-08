import java.util.Arrays;
import java.util.Scanner;

public class Baek_2512_yesan_210208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N+1];
		int su_sum = 0;
		for(int i = 1; i<=N; i++) {
			su_sum += array[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		Arrays.sort(array);
		int right = array[N];
		int middle = 0;
		int sum = 0;
		int left = array[1]; 
		int fresh = 0;
		if(su_sum<=M) System.out.println(array[N]);
		else {
			while(right>=left) {
				middle = (right+left)/2;
				sum = 0;
				fresh = 0;
				for(int i :array) {
					sum += (i>middle)?middle:i;
				}
				if(sum>M) {
					right = middle-1;
				}
				else if(sum<M) {
					left = middle+1;
				}
				else break;
		
			System.out.println(right+" "+left+" "+middle+" "+sum+" "+M);
				
			}
		}
		System.out.println(right);
	}

}
