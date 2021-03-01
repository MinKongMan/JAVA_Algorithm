import java.util.Scanner;

public class Baek_2565_electronicLine_210301 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[501];
		int[] dp = new int[501];
		int max = 0;
		for(int i = 1; i<=N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			max = max>a?max:a;
			max = max>b?max:b;
			array[a] = b;
		}
		
		int temp = 0;
		for(int i = 1; i<=max; i++) {
			if(array[i]==0) continue;
			for(int j = 1; j<i; j++) {
				if(array[j]==0) continue;
				if(array[i]>array[j]) {
//					System.out.println(i+" "+j);
					dp[i]=dp[i]>dp[j]?dp[i]:dp[j];
				}
			}
			
			dp[i]++;
			System.out.println(i+" "+dp[i]);
			temp = dp[i]>temp?dp[i]:temp;
		}
		System.out.println(N-temp);
	}

}
