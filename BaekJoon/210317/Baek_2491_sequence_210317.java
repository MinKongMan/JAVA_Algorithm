import java.util.Scanner;

public class Baek_2491_sequence_210317 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		int max = 0;
		int left = 1;
		int right = 1;
		for(int i = 2; i<=N; i++) {
			if(array[i]>array[i-1]) {
				right++;
				max = left>max?left:max;
				left = 1;
			}
			else if(array[i]<array[i-1]) {
				left++;
				max = right>max?right:max;
				right = 1;
			}
			else if(array[i]==array[i-1]) {
				right++;
				left++;
			}
//			System.out.println(dp[array[i]]+" "+dp2[array[i]]);
		}
		max = max>right?max:right;
		max = max>left?max:left;
		for(int i = 0; i<=9; i++) {
		}
//		System.out.println(max+" "+max2);
		System.out.println(max);
	}

}
