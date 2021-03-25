import java.util.ArrayList;
import java.util.Scanner;

public class Baek_14002_LIS4_210325 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
		int N = sc.nextInt();
		int temp = 0;
		int max = 0;
		int[] array = new int[N+1];
		int[] dp = new int[N+1];
		for(int i = 0; i<=N; i++) {
			ar.add(new ArrayList<Integer>());
		}
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<i; j++) {
				if(array[i]>array[j]) {
					if(dp[i]<dp[j]) {
						dp[i] = dp[j];
						ar.get(i).clear();
						for(Integer k : ar.get(j)) {
							ar.get(i).add(k);
						}
					}
				}
			}
			dp[i]++;
			ar.get(i).add(array[i]);
			if(max<dp[i]) {
				max = dp[i];
				temp = i;
			}
		}
		System.out.println(max);
		for(Integer k : ar.get(temp)) {
			System.out.print(k+" ");
		}
	}

}
