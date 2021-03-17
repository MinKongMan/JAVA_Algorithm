import java.util.Arrays;
import java.util.Scanner;

public class Baek_1499_repairMan_210317 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 1;
		double gap = 0;
		double start = 0;
		double N = sc.nextInt();
		double M = sc.nextInt();
		double[] array = new double[(int)N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		gap = M-0.5;
		start = array[1]-0.5;
		for(int i = 2; i<=N; i++) {
//			System.out.println(i+" "+array[i]+" "+(start+M));
			if(array[i]>start+M) {
				count++;
				start = array[i]-0.5;
			}
		}
		System.out.println(count);
	}

}
