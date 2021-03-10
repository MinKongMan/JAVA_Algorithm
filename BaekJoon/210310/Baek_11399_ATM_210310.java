import java.util.Arrays;
import java.util.Scanner;

public class Baek_11399_ATM_210310 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N];
		int[] answer = new int[N];
		for(int i = 0; i<N; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		int max = 0;
		for(int i = 0; i<N; i++) {
			max += array[i];
			answer[i] = max;
		}
		max = 0;
		for(int i = 0; i<N; i++) {
			max += answer[i];
		}
		System.out.println(max);
	}

}
