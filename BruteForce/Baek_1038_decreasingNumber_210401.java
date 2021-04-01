import java.util.Scanner;

public class Baek_1038_decreasingNumber_210401 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[1000001];
		for(int i = 1; i<=10; i++) {
			dp[i] = i;
		}
		int count = 11;
		long s = 20;
		if(N<=1022) {
		while(count<=N) {
			String k = s+"";
			boolean flag = true;
			int kang = 0;
			for(int i = 0; i<k.length()-1; i++) {
				if(k.charAt(i+1)-'0'>=k.charAt(i)-'0') {
					flag = false;
					kang = k.length()-i;
					break;
				}
			}
			if(flag) {
				dp[count] = Long.parseLong(k);
				s++;
				count++;
			}
			else {
				s = (long) (s/Math.pow(10, kang-1));
				s++;
				s = (long) (s*Math.pow(10, kang-1));
//				System.out.println(s+ " "+count);
			}
		}
		System.out.println(dp[N]);
		}
		else {
			System.out.println("-1");
		}
	}
	

}
