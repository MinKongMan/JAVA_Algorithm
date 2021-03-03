import java.util.Arrays;
import java.util.Scanner;

public class Baek_13458_testSupervision {
	static long [] array;
	static boolean[] marked;
	static long N,M,K,min=Integer.MAX_VALUE, temp = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		array = new long[(int) (N+1)];
		marked = new boolean[(int) (N+1)];
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		M = sc.nextInt();
		K = sc.nextInt();
		for(int i = 1; i<=N; i++) {
			array[i] -= M;
		}
		
		for(int i = 1; i<=N; i++) {
			if(array[i]>=0) {
				temp += (int)Math.ceil((double)array[i]/(double)K);
			}
		}
		System.out.println(temp+N);
	}
}
